package com.exercise.GameApp.GameApp.service;

import com.exercise.GameApp.GameApp.mapper.GameMapper;
import com.exercise.GameApp.GameApp.model.dto.GameDetails;
import com.exercise.GameApp.GameApp.model.dto.GameSummary;
import com.exercise.GameApp.GameApp.model.entity.Game;
import com.exercise.GameApp.GameApp.repository.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    private static final String GAME_NOT_FOUND = "Game not found with ID: ";

    @Override
    public List<GameSummary> getAllGames() {
        // If you have a custom query, you can call it.
        // Otherwise, just do findAll() and map to summaries:
        return gameRepository.findAll().stream()
                .map(gameMapper::toSummary)
                .toList();
    }

    @Override
    public Optional<GameDetails> getById(Long id) {
        return gameRepository.findById(id)
                .map(gameMapper::toDetails);
    }

    @Override
    public boolean saveGame(GameDetails game) {
        if (game == null) {
            return false;
        }
        Game entity = gameMapper.toEntity(game);
        gameRepository.save(entity);
        return true;
    }

    @Override
    public boolean deleteGame(Long id) {
        // Example real delete:
        if (gameRepository.existsById(id)) {
            gameRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void updateGame(Long id, GameDetails gameDetails) {
        if (id == null) {
            throw new EntityNotFoundException("Game ID must not be null.");
        }
        if (gameDetails == null) {
            throw new IllegalArgumentException("Game details must not be null.");
        }

        gameRepository.findById(id).ifPresentOrElse(
                existingGame -> {
                    existingGame.setPlayerOneName(gameDetails.getPlayerOne());
                    existingGame.setPlayerTwoName(gameDetails.getPlayerTwo());
                    existingGame.setStatus(gameDetails.getStatus());
                    gameRepository.save(existingGame);
                },
                () -> {
                    throw new EntityNotFoundException(GAME_NOT_FOUND + id);
                }
        );
    }
}

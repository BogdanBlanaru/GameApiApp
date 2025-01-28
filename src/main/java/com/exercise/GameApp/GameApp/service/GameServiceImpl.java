package com.exercise.GameApp.GameApp.service;

import com.exercise.GameApp.GameApp.model.dto.GameDetails;
import com.exercise.GameApp.GameApp.model.entity.Game;
import com.exercise.GameApp.GameApp.repository.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepo;

    @Autowired
    public GameServiceImpl(GameRepository gameRepo) {
        this.gameRepo = gameRepo;
    }

    @Override
    public List<GameDetails> getAllGames() {
        return gameRepo.findAll().stream()
                .map(game -> new GameDetails(
                        // convert entity -> DTO
                        game.getPlayerOneName(),
                        game.getPlayerTwoName(),
                        game.getStatus()
                ))
                .toList();
    }

    @Override
    public Optional<GameDetails> getById(Long id) {
        return gameRepo.findById(id)
                .map(game -> new GameDetails(
                        game.getPlayerOneName(),
                        game.getPlayerTwoName(),
                        game.getStatus()
                ));
    }

    @Override
    public boolean saveGame(GameDetails gameDetails) {
        if (gameDetails == null) {
            return false;
        }
        Game game = new Game(
                gameDetails.getPlayerOneName(),
                gameDetails.getPlayerTwoName(),
                gameDetails.getStatus()
        );
        // Save entity
        gameRepo.save(game);
        return true;
    }

    @Override
    public boolean deleteGame(Long id) {
        return gameRepo.findById(id)
                .map(existingGame -> {
                    if (!existingGame.isDeleted()) {
                        existingGame.setDeleted(true);
                        gameRepo.save(existingGame);
                        return true;
                    }
                    return false;
                })
                .orElse(false);
    }

    @Override
    public void updateGame(Long id, GameDetails newDetails) {
        if (id == null) {
            throw new EntityNotFoundException("Game ID cannot be null");
        }
        if (newDetails == null) {
            throw new IllegalArgumentException("Game details must not be null");
        }

        gameRepo.findById(id).ifPresentOrElse(
                game -> {
                    game.setPlayerOneName(newDetails.getPlayerOneName());
                    game.setPlayerTwoName(newDetails.getPlayerTwoName());
                    game.setStatus(newDetails.getStatus());
                    gameRepo.save(game);
                },
                () -> {
                    throw new EntityNotFoundException("Game not found with ID: " + id);
                }
        );
    }
}

package com.exercise.GameApp.GameApp.service;

import com.exercise.GameApp.GameApp.model.dto.GameDetails;
import com.exercise.GameApp.GameApp.model.dto.GameSummary;
import com.exercise.GameApp.GameApp.model.entity.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {
    List<GameSummary> getAllGames();                       // Summaries, e.g., ID + basic info
    Optional<GameDetails> getById(Long id);                // Detailed info for a single game

    boolean saveGame(GameDetails game);                    // Create or update a game
    boolean deleteGame(Long id);                           // "Soft delete" or permanent delete
    void updateGame(Long id, GameDetails gameDetails);
}

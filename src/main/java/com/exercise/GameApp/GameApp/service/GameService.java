package com.exercise.GameApp.GameApp.service;

import com.exercise.GameApp.GameApp.model.dto.GameDetails;

import java.util.List;
import java.util.Optional;

public interface GameService {

    List<GameDetails> getAllGames();
    Optional<GameDetails> getById(Long id);
    boolean saveGame(GameDetails gameDetails);
    boolean deleteGame(Long id);
    void updateGame(Long id, GameDetails newDetails);
}

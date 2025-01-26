package com.exercise.GameApp.GameApp.controller;

import com.exercise.GameApp.GameApp.model.dto.GameDetails;
import com.exercise.GameApp.GameApp.model.dto.GameSummary;
import com.exercise.GameApp.GameApp.service.GameService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public List<GameSummary> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/game/{id}")
    public GameDetails getGameById(@PathVariable Long id) {
        Optional<GameDetails> optional = gameService.getById(id);
        // If not found, throw an exception or return 404
        return optional.orElseThrow(() -> new EntityNotFoundException("Game not found with id " + id));
    }

    @PostMapping("/game")
    public boolean createGame(@RequestBody GameDetails request) {
        return gameService.saveGame(request);
    }

    @PutMapping("/game/{id}")
    public void updateGame(@PathVariable Long id, @RequestBody GameDetails request) {
        gameService.updateGame(id, request);
    }

    @DeleteMapping("/game/{id}")
    public boolean deleteGame(@PathVariable Long id) {
        return gameService.deleteGame(id);
    }
}

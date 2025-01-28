package com.exercise.GameApp.GameApp.controller;

import com.exercise.GameApp.GameApp.model.dto.GameDetails;
import com.exercise.GameApp.GameApp.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameDetails> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public GameDetails getGame(@PathVariable Long id) {
        return gameService.getById(id)
                .orElseThrow(() -> new RuntimeException("Game not found"));
    }

    @PostMapping
    public boolean createGame(@RequestBody GameDetails details) {
        return gameService.saveGame(details);
    }

    @DeleteMapping("/{id}")
    public boolean deleteGame(@PathVariable Long id) {
        return gameService.deleteGame(id);
    }

    @PutMapping("/{id}")
    public void updateGame(@PathVariable Long id, @RequestBody GameDetails newDetails) {
        gameService.updateGame(id, newDetails);
    }
}

package com.exercise.GameApp.GameApp;

import com.exercise.GameApp.GameApp.model.dto.GameDetails;
import com.exercise.GameApp.GameApp.model.entity.Game;
import com.exercise.GameApp.GameApp.repository.GameRepository;
import com.exercise.GameApp.GameApp.service.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test") // so we pick up application-test.properties with H2 config
class GameServiceIntegrationTest {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameRepository gameRepository;

    @Test
    void testCreateAndFindGame() {
        // create a new game
        GameDetails gameDetails = new GameDetails("Alice", "Bob", "CREATED");
        gameService.saveGame(gameDetails);

        // verify via repository
        List<Game> games = gameRepository.findAll();
        assertThat(games).hasSize(1);
        assertThat(games.get(0).getPlayerOneName()).isEqualTo("Alice");
    }
}

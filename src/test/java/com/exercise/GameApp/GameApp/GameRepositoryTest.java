package com.exercise.GameApp.GameApp;

import com.exercise.GameApp.GameApp.model.entity.Game;
import com.exercise.GameApp.GameApp.repository.GameRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * A simple test verifying that our repository works with an H2 DB.
 */
@DataJpaTest
class GameRepositoryTest {

    @Autowired
    private GameRepository gameRepository;

    @Test
    @DisplayName("Should save and retrieve a Game entity in H2 in-memory DB")
    void testSaveAndFindById() {
        // 1. Create and save an entity
        Game game = new Game();
        game.setPlayerOneName("Alice");
        game.setPlayerTwoName("Bob");
        game.setStatus("CREATED");
        Game savedGame = gameRepository.save(game);

        // 2. Retrieve by ID
        Game foundGame = gameRepository.findById(savedGame.getId()).orElse(null);

        // 3. Assertions using AssertJ
        assertThat(foundGame).isNotNull();
        assertThat(foundGame.getId()).isEqualTo(savedGame.getId());
        assertThat(foundGame.getPlayerOneName()).isEqualTo("Alice");
        assertThat(foundGame.getPlayerTwoName()).isEqualTo("Bob");
        assertThat(foundGame.getStatus()).isEqualTo("CREATED");
    }
}

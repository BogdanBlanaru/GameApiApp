package com.exercise.GameApp.GameApp;


import com.exercise.GameApp.GameApp.model.entity.Game;
import com.exercise.GameApp.GameApp.repository.GameRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class GameControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GameRepository gameRepository;

    @Test
    void testCreateGame() throws Exception {
        String jsonBody = """
                {
                  "playerOneName": "Alice",
                  "playerTwoName": "Bob",
                  "status": "CREATED"
                }
                """;

        mockMvc.perform(post("/api/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    void testGetAllGames() throws Exception {
        gameRepository.save(new Game("Alice","Bob","CREATED"));

        mockMvc.perform(get("/api/games"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}

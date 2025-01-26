package com.exercise.GameApp.GameApp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDetails {
    private Long id;
    private String playerOne;
    private String playerTwo;
    private String status;
}

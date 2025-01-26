package com.exercise.GameApp.GameApp.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "games")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String playerOneName;
    private String playerTwoName;
    private String status;

    public Game(String playerOneName, String playerTwoName, String status) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
        this.status = status;
    }
}

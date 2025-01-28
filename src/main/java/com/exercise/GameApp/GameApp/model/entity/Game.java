package com.exercise.GameApp.GameApp.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String playerOneName;
    private String playerTwoName;
    private String status;
    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean deleted = false;

    public Game() {
    }

    public Game(String playerOneName, String playerTwoName, String status) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
        this.status = status;
        this.deleted = false;
    }

    public Long getId() {
        return id;
    }

    public String getPlayerOneName() {
        return playerOneName;
    }

    public String getPlayerTwoName() {
        return playerTwoName;
    }

    public String getStatus() {
        return status;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setPlayerOneName(String playerOneName) {
        this.playerOneName = playerOneName;
    }

    public void setPlayerTwoName(String playerTwoName) {
        this.playerTwoName = playerTwoName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}

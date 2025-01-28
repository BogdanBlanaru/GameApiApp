package com.exercise.GameApp.GameApp.model.dto;

public class GameDetails {

    private String playerOneName;
    private String playerTwoName;
    private String status;

    public GameDetails(String playerOneName, String playerTwoName, String status) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
        this.status = status;
    }

    public String getPlayerOneName() {
        return playerOneName;
    }

    public void setPlayerOneName(String playerOneName) {
        this.playerOneName = playerOneName;
    }

    public String getPlayerTwoName() {
        return playerTwoName;
    }

    public void setPlayerTwoName(String playerTwoName) {
        this.playerTwoName = playerTwoName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

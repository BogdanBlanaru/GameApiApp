package com.exercise.GameApp.GameApp.mapper;

import com.exercise.GameApp.GameApp.model.dto.GameDetails;
import com.exercise.GameApp.GameApp.model.dto.GameSummary;
import com.exercise.GameApp.GameApp.model.entity.Game;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class GameMapper {

    public Game toEntity(GameDetails details) {
        if (details == null) {
            return null;
        }
        return new Game(
                details.getPlayerOne(),
                details.getPlayerTwo(),
                details.getStatus()
        );
    }


    public GameDetails toDetails(Game game) {
        if (game == null) {
            return null;
        }
        return new GameDetails(
                game.getId(),
                game.getPlayerOneName(),
                game.getPlayerTwoName(),
                game.getStatus()
        );
    }

    public GameSummary toSummary(Game game) {
        if (game == null) {
            return null;
        }
        return new GameSummary(
                game.getId(),
                game.getStatus()
        );
    }
}

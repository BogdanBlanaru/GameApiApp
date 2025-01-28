package com.exercise.GameApp.GameApp.mapper;

import com.exercise.GameApp.GameApp.model.dto.GameDetails;
import com.exercise.GameApp.GameApp.model.entity.Game;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameMapper {

    Game toEntity(GameDetails details);

    GameDetails toDto(Game entity);
}

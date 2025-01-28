package com.exercise.GameApp.GameApp.repository;

import com.exercise.GameApp.GameApp.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}

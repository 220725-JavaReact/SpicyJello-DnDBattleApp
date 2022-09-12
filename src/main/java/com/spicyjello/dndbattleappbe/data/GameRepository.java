package com.spicyjello.dndbattleappbe.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spicyjello.dndbattleappbe.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

}

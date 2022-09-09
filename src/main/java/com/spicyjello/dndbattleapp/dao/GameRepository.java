package com.spicyjello.dndbattleapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spicyjello.dndbattleapp.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

}

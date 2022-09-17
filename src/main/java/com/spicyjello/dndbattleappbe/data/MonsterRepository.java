package com.spicyjello.dndbattleappbe.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spicyjello.dndbattleappbe.model.Monster;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Integer> {
	public List<Monster> findAllByGame_Id(int gameId);
}

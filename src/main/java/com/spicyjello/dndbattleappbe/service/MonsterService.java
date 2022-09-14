package com.spicyjello.dndbattleappbe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spicyjello.dndbattleappbe.data.MonsterRepository;
import com.spicyjello.dndbattleappbe.model.Monster;

@Service
public class MonsterService {
	@Autowired
	private MonsterRepository monsterRepo;
	public Monster addMonster(Monster newMonster) {
		return monsterRepo.save(newMonster);
	}
	public List<Monster> getAllMonsters() {
		return monsterRepo.findAll();
	}
	public List<Monster> getAllMonstersByGameId(int id) {
		return monsterRepo.findAllByGameId(id);
	}
	public Optional<Monster> getMonsterById(int id) {
		return monsterRepo.findById(id);
	}
	public Monster updateMonster(Monster updatedMonster) {
		Optional<Monster> foundMonster = getMonsterById(updatedMonster.getId());
		if (foundMonster.isPresent()) return monsterRepo.save(updatedMonster);
		else return new Monster();
	}
	public Boolean deleteMonsterById(int id) {
		monsterRepo.deleteById(id);
		return !monsterRepo.existsById(id);
	}
}

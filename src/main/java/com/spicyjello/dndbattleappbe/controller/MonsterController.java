package com.spicyjello.dndbattleappbe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spicyjello.dndbattleappbe.model.Monster;
import com.spicyjello.dndbattleappbe.service.MonsterService;

@RestController
@RequestMapping("/api/monsters")
public class MonsterController {
	@Autowired
	private MonsterService monsterService;
	@PostMapping
	public Monster addMonster(@RequestBody Monster newMonster) {
		return monsterService.addMonster(newMonster);
	}
	@GetMapping
	public List<Monster> getAllMonsters() {
		return monsterService.getAllMonsters();
	}
	@GetMapping("/game/{id}")
	public List<Monster> getAllMonstersByGameId(@PathVariable String id) {
		return monsterService.getAllMonstersByGameId(Integer.parseInt(id));
	}
	@GetMapping("{id}")
	public Monster getMonsterById(@PathVariable String id) {
		Optional<Monster> foundMonster = monsterService.getMonsterById(Integer.parseInt(id));
		if (foundMonster.isPresent()) return foundMonster.get();
		else return new Monster();
	}
	@PutMapping
	public Monster updateMonster(@RequestBody Monster updatedMonster) {
		return monsterService.updateMonster(updatedMonster);
	}
	@DeleteMapping("{id}")
	public Boolean deleteMonsterById(@PathVariable String id) {
		return monsterService.deleteMonsterById(Integer.parseInt(id));
	}
}

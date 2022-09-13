package com.spicyjello.dndbattleappbe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}

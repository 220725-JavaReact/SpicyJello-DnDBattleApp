package com.spicyjello.dndbattleappbe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spicyjello.dndbattleappbe.model.Game;
import com.spicyjello.dndbattleappbe.service.GameService;

@RestController
@RequestMapping("/api/games")
public class GameController {
	@Autowired
	private GameService gameService;
	@PostMapping
	public Game addGame(@RequestBody Game newGame) {
		return gameService.addGame(newGame);
	}
	@GetMapping
	public List<Game> getAllGames() {
		return gameService.getAllGames();
	}
}

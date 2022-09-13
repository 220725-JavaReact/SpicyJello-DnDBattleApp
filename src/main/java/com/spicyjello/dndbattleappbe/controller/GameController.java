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
	@GetMapping("/user/{id}")
	public List<Game> getAllGamesByUserId(@PathVariable String id) {
		return gameService.getAllGamesByUserId(Integer.parseInt(id));
	}
	@GetMapping("{id}")
	public Game getGameById(@PathVariable String id) {
		Optional<Game> foundGame = gameService.getGameById(Integer.parseInt(id));
		if (foundGame.isPresent()) return foundGame.get();
		else return new Game();
	}
	@PutMapping
	public Game updateGame(@RequestBody Game updatedGame) {
		return gameService.updateGame(updatedGame);
	}
	@DeleteMapping("{id}")
	public Boolean deleteGameById(@PathVariable String id) {
		return gameService.deleteGameById(Integer.parseInt(id));
	}
}

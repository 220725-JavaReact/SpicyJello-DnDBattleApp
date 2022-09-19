package com.spicyjello.dndbattleappbe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spicyjello.dndbattleappbe.data.GameRepository;
import com.spicyjello.dndbattleappbe.model.Game;

@Service
public class GameService {
	@Autowired
	private GameRepository gameRepo;
	public Game addGame(Game newGame) {
		return gameRepo.save(newGame);
	}
	public List<Game> getAllGames() {
		return gameRepo.findAll();
	}
	public List<Game> getAllGamesByUserId(int id) {
		return gameRepo.findAllByUser_Id(id);
	}
	public Optional<Game> getGameById(int id) {
		return gameRepo.findById(id);
	}
	public Game updateGame(Game updatedGame) {
		Optional<Game> foundGame = getGameById(updatedGame.getId());
		if (foundGame.isPresent()) return gameRepo.save(updatedGame);
		else return new Game();
	}
	public Boolean deleteGameById(int id) {
		gameRepo.deleteById(id);
		return !gameRepo.existsById(id);
	}
}

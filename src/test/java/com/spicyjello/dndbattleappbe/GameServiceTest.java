package com.spicyjello.dndbattleappbe;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spicyjello.dndbattleappbe.data.GameRepository;
import com.spicyjello.dndbattleappbe.model.Game;
import com.spicyjello.dndbattleappbe.model.User;
import com.spicyjello.dndbattleappbe.service.GameService;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {
	
	@Mock
	private GameRepository mockGameRepo;
	
	@InjectMocks
	GameService gameService;
	
	private Game game1;
	private Game game2;
	private Game game3;
	
	@BeforeEach
	public void init() {
		User user = new User();
		game1 = new Game(1, user, 1, 1, null);
		game2 = new Game(2, user, 2, 2, null);
		game3 = new Game(3, user, 3, 3, null);
	}

	@Test
	void AddGame_Pass() {
		when(mockGameRepo.save(game1)).thenReturn(game1);
		
		Game actual = gameService.addGame(game1);
		
		Assertions.assertEquals(game1, actual);
	}
	
	@Test
	void GetAllGames_Pass() {
		List<Game> games = new ArrayList<>();
		games.add(game1);
		games.add(game2);
		games.add(game3);
		when(mockGameRepo.findAll()).thenReturn(games);
		
		List<Game> actual = gameService.getAllGames();
				
		Assertions.assertEquals(games, actual);
	}
	
	@Test
	void GetGameById_Pass(){
		Optional<Game> oGame = Optional.ofNullable(game1);
		
		when(mockGameRepo.findById(1)).thenReturn(oGame);
		
		Optional<Game> actual = gameService.getGameById(1);
		
		Assertions.assertEquals(oGame, actual);
	}

}

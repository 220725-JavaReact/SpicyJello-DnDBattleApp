package com.spicyjello.dndbattleappbe;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spicyjello.dndbattleappbe.data.MonsterRepository;
import com.spicyjello.dndbattleappbe.model.Game;
import com.spicyjello.dndbattleappbe.model.Monster;
import com.spicyjello.dndbattleappbe.service.MonsterService;

@ExtendWith(MockitoExtension.class)
class MonsterServiceTest {
	
	@Mock
	MonsterRepository mockMonsterRepo;
	
	@InjectMocks
	MonsterService monsterService;
	
	private Monster monster1;
	private Monster monster2;
	private Monster monster3;
	
	@BeforeEach
	public void init() {
		Game game = new Game();
		monster1 = new Monster(1, game, "Baby Bear Owl", "Spicy Boi");
		monster2 = new Monster(2, game, "Sulvamente Ganondorf", "Pesamente");
		monster3 = new Monster(3, game, "Lord of the Flies", "Piggy");
		
		
	}

	@Test
	void AddMonster_Pass() {
		when(mockMonsterRepo.save(monster1)).thenReturn(monster1);
		
		Monster actual = monsterService.addMonster(monster1);
		
		Assertions.assertEquals(monster1, actual);
	}
	
	@Test
	void GetAllMonsters_Pass() {
		List<Monster> monsters = new ArrayList<>();
		monsters.add(monster1);
		monsters.add(monster2);
		monsters.add(monster3);
		
		when(mockMonsterRepo.findAll()).thenReturn(monsters);
		
		List<Monster> actual = monsterService.getAllMonsters();
		
		Assertions.assertEquals(monsters, actual);
	}
	
	@Test
	void GetMonsterById_Pass() {
		Optional<Monster> oMonster = Optional.ofNullable(monster1);
		
		when(mockMonsterRepo.findById(1)).thenReturn(oMonster);
		
		Optional<Monster> actual = monsterService.getMonsterById(1);
		
		Assertions.assertEquals(oMonster, actual);
	}

}

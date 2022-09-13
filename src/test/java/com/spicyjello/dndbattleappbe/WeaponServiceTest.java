package com.spicyjello.dndbattleappbe;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spicyjello.dndbattleappbe.data.WeaponRepository;
import com.spicyjello.dndbattleappbe.model.User;
import com.spicyjello.dndbattleappbe.model.Weapon;
import com.spicyjello.dndbattleappbe.service.WeaponService;

@ExtendWith(MockitoExtension.class)
class WeaponServiceTest {
	
	@Mock
	WeaponRepository mockWeaponRepo;
	
	@InjectMocks
	WeaponService weaponService;
	
	private Weapon weapon1;
	private Weapon weapon2;
	private Weapon weapon3;
	private List<Weapon> weapons;
	
	@BeforeEach
	public void init() {
		Set<User> users = new HashSet<>();
		users.add(new User());
		weapon1 = new Weapon(1, "A swerd", "Sharp and pokey", "kinda a lot", users);
		weapon2 = new Weapon(1, "Walter Cronkite", "Black and White", "Tells you things", users);
		weapon3 = new Weapon(1, "Mambo No. 5", "One, Two, Three, Four, Five", "Everybody in the car, so come on, let's ride", users);
		weapons = new ArrayList<>(Arrays.asList(weapon1, weapon2, weapon3));
	}

	@Test
	void CreateWeapon_Pass() {
		when(mockWeaponRepo.save(weapon1)).thenReturn(weapon1);
		
		Weapon actual = weaponService.addWeapon(weapon1);
		
		Assertions.assertEquals(weapon1, actual);
	}
	
	@Test 
	void GetAllWeapons_Pass(){
		when(mockWeaponRepo.findAll()).thenReturn(weapons);
		
		List<Weapon> actual = weaponService.getAllWeapons();
		
		Assertions.assertEquals(weapons, actual);
	}
	
	@Test
	void GetUserId_Pass() {
		Optional<Weapon> oWeapon = Optional.ofNullable(weapon2);
		
		when(mockWeaponRepo.findById(2)).thenReturn(oWeapon);
		
		Optional<Weapon> actual = weaponService.getWeaponsById(2);
		
		Assertions.assertEquals(oWeapon, actual);
	}

}

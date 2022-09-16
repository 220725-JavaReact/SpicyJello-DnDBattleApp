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

import com.spicyjello.dndbattleappbe.data.UpgradeRepository;
import com.spicyjello.dndbattleappbe.model.Upgrade;
import com.spicyjello.dndbattleappbe.model.User;
import com.spicyjello.dndbattleappbe.service.UpgradeService;

@ExtendWith(MockitoExtension.class)
class UpgradeServiceTest {
	
	@Mock
	UpgradeRepository mockUpgradeRepo;
	
	@InjectMocks
	UpgradeService upgradeService;
	
	private Upgrade upgrade1;
	private Upgrade upgrade2;
	private Upgrade upgrade3;
	private List<Upgrade> upgrades;
	
	@BeforeEach
	public void init() {
		Set<User> users = new HashSet<>();
		users.add(new User());
		upgrade1 = new Upgrade(1, "Vineger", "Savory", "Sour", users);
		upgrade2 = new Upgrade(2, "BBQ", "Sweet", "Tangy", users);
		upgrade3 = new Upgrade(3, "Mayo", "Creamy", "Smooth", users);
		upgrades = new ArrayList<>(Arrays.asList(upgrade1, upgrade2, upgrade3));
	}
	

	@Test
	void AddUpgrade_Pass() {
		when(mockUpgradeRepo.save(upgrade1)).thenReturn(upgrade1);
		
		Upgrade actual = upgradeService.addUpgrade(upgrade1);
		
		Assertions.assertEquals(upgrade1, actual);
	}
	
	@Test
	void GetAllUpgrade_Pass() {
		when(mockUpgradeRepo.findAll()).thenReturn(upgrades);
		
		List<Upgrade> actual = upgradeService.getAllUpgrades();
		
		Assertions.assertEquals(upgrades, actual);
	}
	
	@Test
	void GetUserId_Pass() {
		Optional<Upgrade> oUpgrade = Optional.ofNullable(upgrade3);
		
		when(mockUpgradeRepo.findById(3)).thenReturn(oUpgrade);
		
		Optional<Upgrade> actual = upgradeService.getUpgradeById(3);
		
		Assertions.assertEquals(oUpgrade, actual);
	}

}

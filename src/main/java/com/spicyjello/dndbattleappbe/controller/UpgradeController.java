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

import com.spicyjello.dndbattleappbe.model.Upgrade;
import com.spicyjello.dndbattleappbe.service.UpgradeService;

@RestController
@RequestMapping("/api/upgrades")
public class UpgradeController {
	@Autowired
	private UpgradeService upgradeService;
	@PostMapping
	public Upgrade addUpgrade(@RequestBody Upgrade newUpgrade) {
		return upgradeService.addUpgrade(newUpgrade);
	}
	@GetMapping
	public List<Upgrade> getAllUpgrades() {
		return upgradeService.getAllUpgrades();
	}
	@GetMapping("/user/{id}")
	public List<Upgrade> getAllUpgradesByUserId(@PathVariable String id) {
		return upgradeService.getAllUpgradesByUserId(Integer.parseInt(id));
	}
	@GetMapping("{id}")
	public Upgrade getUpgradeById(@PathVariable String id) {
		Optional<Upgrade> foundUpgrade = upgradeService.getUpgradeById(Integer.parseInt(id));
		if (foundUpgrade.isPresent()) return foundUpgrade.get();
		else {
			Upgrade notFoundUpgrade = new Upgrade();
			notFoundUpgrade.setName("Upgrade not found");
			return notFoundUpgrade;
		}
	}
	@PutMapping
	public Upgrade updateUpgrade(@RequestBody Upgrade updatedUpgrade) {
		return upgradeService.updateUpgrade(updatedUpgrade);
	}
	@DeleteMapping("{id}")
	public Boolean deleteUpgradeById(@PathVariable String id) {
		return upgradeService.deleteUpgradeById(Integer.parseInt(id));
	}
}

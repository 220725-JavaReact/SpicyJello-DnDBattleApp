package com.spicyjello.dndbattleappbe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}

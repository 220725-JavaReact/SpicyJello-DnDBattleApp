package com.spicyjello.dndbattleappbe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spicyjello.dndbattleappbe.model.Weapon;
import com.spicyjello.dndbattleappbe.service.WeaponService;

@RestController
@RequestMapping("/api/weapons")
public class WeaponController {
	@Autowired
	private WeaponService weaponService;
	@PostMapping
	public Weapon addWeapon(@RequestBody Weapon newWeapon) {
		return weaponService.addWeapon(newWeapon);
	}
	@GetMapping
	public List<Weapon> getAllWeapons() {
		return weaponService.getAllWeapons();
	}
}

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
	@GetMapping("/user/{id}")
	public List<Weapon> getAllWeaponsByUserId(@PathVariable String id) {
		return weaponService.getAllWeaponsByUserId(Integer.parseInt(id));
	}
	@GetMapping("{id}")
	public Weapon getWeaponById(@PathVariable String id) {
		Optional<Weapon> foundWeapon = weaponService.getWeaponById(Integer.parseInt(id));
		if (foundWeapon.isPresent()) return foundWeapon.get();
		else {
			Weapon notFoundWeapon = new Weapon();
			notFoundWeapon.setName("Weapon not found");
			return notFoundWeapon;
		}
	}
	@PutMapping
	public Weapon updateWeapon(@RequestBody Weapon updatedWeapon) {
		return weaponService.updateWeapon(updatedWeapon);
	}
	@DeleteMapping("{id}")
	public Boolean deleteWeaponById(@PathVariable String id) {
		return weaponService.deleteWeaponById(Integer.parseInt(id));
	}
}

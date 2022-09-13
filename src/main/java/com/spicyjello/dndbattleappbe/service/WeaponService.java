package com.spicyjello.dndbattleappbe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spicyjello.dndbattleappbe.data.WeaponRepository;
import com.spicyjello.dndbattleappbe.model.Weapon;

@Service
public class WeaponService {
	@Autowired
	private WeaponRepository weaponRepo;
	public Weapon addWeapon(Weapon newWeapon) {
		return weaponRepo.save(newWeapon);
	}
	public List<Weapon> getAllWeapons() {
		return weaponRepo.findAll();
	}
	public Optional<Weapon> getWeaponsById(int id) {
		return weaponRepo.findById(id);
	}
	public Boolean deleteWeaponById(int id) {
		weaponRepo.deleteById(id);
		return !weaponRepo.existsById(id);
	}
}

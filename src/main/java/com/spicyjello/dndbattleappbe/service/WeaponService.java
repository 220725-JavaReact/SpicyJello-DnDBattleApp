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
	public List<Weapon> getAllWeaponsByUserId(int id) {
		return weaponRepo.findAllByUserId(id);
	}
	public Optional<Weapon> getWeaponById(int id) {
		return weaponRepo.findById(id);
	}
	public Weapon updateWeapon(Weapon updatedWeapon) {
		Optional<Weapon> foundWeapon = getWeaponById(updatedWeapon.getId());
		if (foundWeapon.isPresent()) return foundWeapon.get();
		else {
			Weapon notFoundWeapon = new Weapon();
			notFoundWeapon.setName("Weapon not found");
			return notFoundWeapon;
		}
	}
	public Boolean deleteWeaponById(int id) {
		weaponRepo.deleteById(id);
		return !weaponRepo.existsById(id);
	}
}

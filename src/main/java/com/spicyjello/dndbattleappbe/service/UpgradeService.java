package com.spicyjello.dndbattleappbe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spicyjello.dndbattleappbe.data.UpgradeRepository;
import com.spicyjello.dndbattleappbe.model.Upgrade;

@Service
public class UpgradeService {
	@Autowired
	private UpgradeRepository upgradeRepo;
	public Upgrade addUpgrade(Upgrade newUpgrade) {
		return upgradeRepo.save(newUpgrade);
	}
	public List<Upgrade> getAllUpgrades() {
		return upgradeRepo.findAll();
	}
	public List<Upgrade> getAllUpgradesByUserId(int id) {
		return upgradeRepo.findAllByUsers_Id(id);
	}
	public Optional<Upgrade> getUpgradeById(int id) {
		return upgradeRepo.findById(id);
	}
	public Upgrade updateUpgrade(Upgrade updatedUpgrade) {
		Optional<Upgrade> foundUpgrade = getUpgradeById(updatedUpgrade.getId());
		if (foundUpgrade.isPresent()) return foundUpgrade.get();
		else {
			Upgrade notFoundUpgrade = new Upgrade();
			notFoundUpgrade.setName("Upgrade not found");
			return notFoundUpgrade;
		}
	}
	public Boolean deleteUpgradeById(int id) {
		upgradeRepo.deleteById(id);
		return !upgradeRepo.existsById(id);
	}
}

package com.spicyjello.dndbattleappbe.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spicyjello.dndbattleappbe.model.Weapon;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Integer> {
	public List<Weapon> findAllByUsers_Id(int userId);
}

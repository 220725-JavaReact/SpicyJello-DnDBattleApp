package com.spicyjello.dndbattleappbe.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spicyjello.dndbattleappbe.model.Weapon;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Integer> {

}

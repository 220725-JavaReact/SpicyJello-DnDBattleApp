package com.spicyjello.dndbattleapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spicyjello.dndbattleapp.model.Weapon;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Integer> {

}

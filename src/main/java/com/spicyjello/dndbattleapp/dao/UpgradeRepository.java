package com.spicyjello.dndbattleapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spicyjello.dndbattleapp.model.Upgrade;

@Repository
public interface UpgradeRepository extends JpaRepository<Upgrade, Integer> {

}

package com.spicyjello.dndbattleappbe.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spicyjello.dndbattleappbe.model.Upgrade;

@Repository
public interface UpgradeRepository extends JpaRepository<Upgrade, Integer> {
	public List<Upgrade> findAllByUsers_Id(int userId);
}

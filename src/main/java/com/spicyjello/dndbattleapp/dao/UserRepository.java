package com.spicyjello.dndbattleapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spicyjello.dndbattleapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
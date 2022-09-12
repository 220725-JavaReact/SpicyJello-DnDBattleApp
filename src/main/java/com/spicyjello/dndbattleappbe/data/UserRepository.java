package com.spicyjello.dndbattleappbe.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spicyjello.dndbattleappbe.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}

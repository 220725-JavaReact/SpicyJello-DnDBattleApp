package com.spicyjello.dndbattleappbe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spicyjello.dndbattleappbe.data.UserRepository;
import com.spicyjello.dndbattleappbe.model.User;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	public User addUser(User newUser) {
		return userRepo.save(newUser);
	}
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	public Optional<User> getUserById(int id) {
		return userRepo.findById(id);
	}
	public Boolean deleteUserById(int id) {
		userRepo.deleteById(id);
		return !userRepo.existsById(id);
	}
}

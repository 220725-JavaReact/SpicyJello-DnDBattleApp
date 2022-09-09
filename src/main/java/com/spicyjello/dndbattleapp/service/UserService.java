package com.spicyjello.dndbattleapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spicyjello.dndbattleapp.dao.UserRepository;
import com.spicyjello.dndbattleapp.model.User;



@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public User createUser(User user) {
		
		return userRepo.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public Optional<User> getUserById(int id){
		return userRepo.findById(id);
	}
	
	
	public Boolean deleteUser(int id) {
		userRepo.deleteById(id);
		return !userRepo.existsById(id);
	}
	
}

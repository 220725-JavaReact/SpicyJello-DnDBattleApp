package com.spicyjello.dndbattleappbe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spicyjello.dndbattleappbe.model.User;
import com.spicyjello.dndbattleappbe.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping
	public User addUser(@RequestBody User newUser) {
		return userService.addUser(newUser);
	}
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	@GetMapping("/id/{id}")
	public User getUserById(@PathVariable String id) {
		Optional<User> foundUser = userService.getUserById(Integer.parseInt(id));
		if (foundUser.isPresent()) return foundUser.get();
		else {
			User notFoundUser = new User();
			notFoundUser.setName("User not found");
			return notFoundUser;
		}
	}
	@GetMapping("/username/{username}")
	public User getUserByUsername(@PathVariable String username) {
		Optional<User> foundUser = userService.getUserByUsername(username);
		if (foundUser.isPresent()) return foundUser.get();
		else {
			User notFoundUser = new User();
			notFoundUser.setName("User not found");
			return notFoundUser;
		}
	}
	@PutMapping
	public User updateUser(@RequestBody User updatedUser) {
		return userService.updateUser(updatedUser);
	}
	@DeleteMapping("/id/{id}")
	public Boolean deleteUserById(@PathVariable String id) {
		return userService.deleteUserById(Integer.parseInt(id));
	}
}

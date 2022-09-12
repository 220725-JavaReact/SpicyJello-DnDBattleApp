package com.spicyjello.dndbattleappbe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}

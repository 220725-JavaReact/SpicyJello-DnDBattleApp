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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Setter
	private static class LoginInfo {
		String username;
		String password;
	};
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
	@GetMapping("{identifier}")
	public User getUserByIdentifier(@PathVariable String identifier) {
		User user = new User();
		if (identifier.matches("^\\d+$")) {
			Optional<User> foundUser = userService.getUserById(Integer.parseInt(identifier));
			if (foundUser.isPresent()) user = foundUser.get();
			else user.setName("User not found");
		} else {
			Optional<User> foundUser = userService.getUserByUsername(identifier);
			if (foundUser.isPresent()) user = foundUser.get();
			else user.setName("User not found");
		}
		return user;
	}
	@PostMapping("login")
	public User getUserByValidation(@RequestBody LoginInfo loginInfo) {
		return userService.getUserByValidation(loginInfo.getUsername(), loginInfo.getPassword());
	}
	@PutMapping
	public User updateUser(@RequestBody User updatedUser) {
		return userService.updateUser(updatedUser);
	}
	@DeleteMapping("{id}")
	public Boolean deleteUserById(@PathVariable String id) {
		return userService.deleteUserById(Integer.parseInt(id));
	}
}

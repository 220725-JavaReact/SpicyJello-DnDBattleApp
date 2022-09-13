package com.spicyjello.dndbattleappbe;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spicyjello.dndbattleappbe.data.UserRepository;
import com.spicyjello.dndbattleappbe.model.User;
import com.spicyjello.dndbattleappbe.service.UserService;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	
	@Mock
	UserRepository mockUserRepo;
	
	@InjectMocks
	UserService userService;
	
	private User user;
	private User user1;
	private User user2;
	private List<User> users1;
	private List<User> users2;
	
	
	@BeforeEach
	public void init() {
		
		user = new User(1,"Tom", "Salta", null, null, 1, null, null, null );
		user1 = new User(2, "John", "Constantine", null, null, 2, null, null, null);
		user2 = new User(3, "J'onn", "J'onzz", null, null, 2, null, null, null);
		users1 = new ArrayList<>();
		users1.add(user);
		users1.add(user1);
		users2 = new ArrayList<>();
		users2.add(user1);
		users2.add(user2);
	}

	@Test
	void CreateUser_Pass() {
		
		
		when(mockUserRepo.save(user)).thenReturn(user);
		
		User actual = userService.addUser(user);
		
		Assertions.assertEquals(user, actual);
	}
	
	@Test
	void GetAllUsers_Pass() {
		
		when(mockUserRepo.findAll()).thenReturn(users1);
		
		List<User> actual = userService.getAllUsers();
		
		Assertions.assertEquals(users1, actual);
	}
	
	@Test
	void GetUserId_Pass() {
		Optional<User> oUser = Optional.ofNullable(user);
		
		when(mockUserRepo.findById(1)).thenReturn(oUser);
		
		Optional<User> actual = userService.getUserById(1);
		
		Assertions.assertEquals(oUser, actual);
	}
	

}

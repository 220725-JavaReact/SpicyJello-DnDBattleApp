package com.spicyjello.dndbattleappbe;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spicyjello.dndbattleappbe.data.UserRepository;
import com.spicyjello.dndbattleappbe.model.User;
import com.spicyjello.dndbattleappbe.service.UserService;
import com.spicyjello.dndbattleappbe.util.PasswordFactory;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	
	@Mock
	UserRepository mockUserRepo;
	
	@Mock
	PasswordFactory mockPasswordFactory;
	
	@InjectMocks
	UserService userService;
	
	private User user;
	private User user1;
	private User user2;
	private List<User> users1;
	private List<User> users2;
	
	
	@BeforeEach
	public void init() {
		
		user = new User(1,"Tom", "Salta", "word", "word", 1, null, null, null );
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
		
		when(mockPasswordFactory.encodePassword("word")).thenReturn(user.getPassword());
		when(mockUserRepo.save(user)).thenReturn(user);
		
		User actual = userService.addUser(user);
		System.out.println(actual);
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
	
	@Test
	void GetUserUsername_Pass() { //also tests get user by username
		Optional<User> oUser = Optional.ofNullable(user);
		
		when(mockUserRepo.findByUsername(user.getUsername())).thenReturn(oUser);
		when(mockPasswordFactory.matchPassword(user.getPassword(), user.getPassword())).thenReturn(true);
		//above call need to be mocked because it compares hashed pw from db
		User actual = userService.getUserByValidation(user.getUsername(), "word");
		
		Assertions.assertEquals(user, actual);
	}
	

}

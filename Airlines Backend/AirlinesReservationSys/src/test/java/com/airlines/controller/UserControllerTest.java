package com.airlines.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.airlines.entities.User;
import com.airlines.exception.UserNotFoundException;
import com.airlines.model.AuthResponse;
import com.airlines.model.UserLoginModel;
import com.airlines.model.UserModel;
import com.airlines.repositories.UserRepository;
import com.airlines.services.UserService;

class UserControllerTest {

	@Mock
	UserService userService;
	@InjectMocks
	UserController userController;
	@Mock
	UserRepository userRepository;

	UserLoginModel userLogin = new UserLoginModel("userName", "email@gmail.com", "password");

	User user = new User();

	UserModel userModel = new UserModel(1, "password", "userName", "First", "last", 123456790L, "role",
			"mail@gmail.com", new Date(), "female");

	AuthResponse response = new AuthResponse("userName", "email@gmail.com", true);

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testUserLogin() throws UserNotFoundException {
		ResponseEntity<AuthResponse> res = userController.login(userLogin);
		assertNotNull(res);
	}

	@Test
	void testRegister() throws UserNotFoundException {

		userModel.setUserRole("customer");
		userService.registerUser(userModel);
		ResponseEntity<User> user = userController.register(userModel);
		assertNotNull(user);

	}
}

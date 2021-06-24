package com.airlines.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.airlines.exception.UserNotFoundException;
import com.airlines.model.UserLoginModel;
import com.airlines.model.UserModel;
import com.airlines.repositories.UserRepository;

class UserServiceImplTest {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserServiceImpl userService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	UserLoginModel user = new UserLoginModel("username", "email@gmail.com", "password");

	@Test
	void testValidateException() {
		when(userRepository.findByEmailIdAndPassword("email@gmail,com", "password")).thenReturn(null);
		assertThrows(UserNotFoundException.class, () -> userService.validate(user));

	}

	@Test
	void testRegister() {
		UserModel user1 = new UserModel();
		user1.setDateOfBirth(null);
		user1.setEmailId("a@gmail.com");
		user1.setFirstName("firstname");
		user1.setLastName("lastame");
		user1.setPassword("password");
		user1.setPhoneNumber(1234567890L);
		user1.setGender("female");
		user1.setUserName("uerName");

		assertFalse(userService.registerUser(user1) != null);
	}

}

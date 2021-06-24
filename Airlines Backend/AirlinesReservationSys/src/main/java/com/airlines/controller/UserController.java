package com.airlines.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airlines.entities.User;
import com.airlines.exception.UserNotFoundException;
import com.airlines.model.AuthResponse;
import com.airlines.model.UserLoginModel;
import com.airlines.model.UserModel;
import com.airlines.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody UserModel userModel) throws UserNotFoundException {
		userModel.setUserRole("customer");
		User user1= userService.registerUser(userModel);
		return new ResponseEntity(user1,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody UserLoginModel user) throws UserNotFoundException {
		AuthResponse authResponse=userService.validate(user);
			return new ResponseEntity<AuthResponse>(authResponse,HttpStatus.OK);
		
	}

}

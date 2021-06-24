package com.airlines.services;

import com.airlines.entities.User;
import com.airlines.exception.UserNotFoundException;
//import com.airlines.pojos.AuthReponse;
import com.airlines.model.AuthResponse;
import com.airlines.model.UserLoginModel;
import com.airlines.model.UserModel;


public interface UserService {

	User registerUser(UserModel userModel) throws UserNotFoundException;
	AuthResponse validate(UserLoginModel user) throws UserNotFoundException;
	
}

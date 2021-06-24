package com.airlines.services;

import org.springframework.stereotype.Service;

import com.airlines.entities.User;
import com.airlines.exception.UserNotFoundException;
import com.airlines.model.AuthResponse;
import com.airlines.model.UserLoginModel;
import com.airlines.model.UserModel;
import com.airlines.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	

	private UserRepository userRepository;
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public User registerUser(UserModel userModel) {

		User user1= new User();
		user1.setUserName(userModel.getUserName());
		user1.setPhoneNumber(userModel.getPhoneNumber());
		user1.setDateOfBirth(userModel.getDateOfBirth());
		user1.setEmailId(userModel.getEmailId());
		user1.setFirstName(userModel.getFirstName());
		user1.setLastName(userModel.getLastName());
		user1.setPassword(userModel.getPassword());
		return 	userRepository.save(user1);
		
	}

	public AuthResponse validate(UserLoginModel user) throws UserNotFoundException {

		AuthResponse authResponse= null;
		User user1= userRepository.findByEmailIdAndPassword(user.getEmailId(), user.getPassword());
		if(user1!=null) {
			authResponse = new AuthResponse();
			authResponse.setUserName(user1.getUserName());
			authResponse.setEmailId(user1.getEmailId());
			authResponse.setAuthenticationStatus(true);
			if(user1.getUserRole()!=null) {
				authResponse.setAdmin(user1.getUserRole().equals("admin"));
			}
			
			return authResponse;
		}
		else {
			throw new UserNotFoundException("User not found with emailId and password");
		}
	}

	

}

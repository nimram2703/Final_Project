package com.airlines.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airlines.entities.Passenger;
import com.airlines.entities.User;
import com.airlines.exception.UserNotFoundException;
import com.airlines.model.PassengerModel;
import com.airlines.repositories.PassengerRepository;
import com.airlines.repositories.UserRepository;

@Service
public class PassengerServiceImpl implements PassengerService {

	private PassengerRepository passengerRepository;
	private UserRepository userRepository;

	public PassengerServiceImpl(PassengerRepository passengerRepository, UserRepository userRepository) {
		super();
		this.passengerRepository = passengerRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Passenger addPassengers(PassengerModel passenger) throws UserNotFoundException {

		User user = userRepository.findByUserName(passenger.getUsername());
		if (user != null) {
			Passenger passenger2=new Passenger();
			passenger2.setPassengerName(passenger.getPassengerName());
			passenger2.setAge(passenger.getAge());
			passenger2.setAddress(passenger.getAddress());
			passenger2.setGender(passenger.getGender());
			passenger2.setMobileNumber(passenger.getMobileNumber());
			passenger2.setEmailId(passenger.getEmailId());
			user.addPassenger(passenger2);
			passenger2.setUser(user);
			return passengerRepository.save(passenger2);
		} else {
			throw new UserNotFoundException("User Not found");
		}

	}

	@Override
	public List<Passenger> getAllPassengers(Passenger passenger, String userName) {

		User user = userRepository.findByUserName(userName);

		user.getPassenger();

		return passengerRepository.findAll();
	}

}

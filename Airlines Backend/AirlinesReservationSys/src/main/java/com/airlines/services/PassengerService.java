package com.airlines.services;

import java.util.List;

import com.airlines.entities.Passenger;
import com.airlines.exception.UserNotFoundException;
import com.airlines.model.PassengerModel;

public interface PassengerService {

	//public Passenger addPassengers(Passenger passenger);
	//public List<Passenger> getAllPassengers(Passenger passenger);
	Passenger addPassengers(PassengerModel passenger) throws UserNotFoundException;
	List<Passenger> getAllPassengers(Passenger passenger, String userName);
}

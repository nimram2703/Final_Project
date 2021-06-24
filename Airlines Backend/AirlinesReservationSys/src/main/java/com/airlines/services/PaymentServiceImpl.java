package com.airlines.services;

import com.airlines.entities.Payment;
import com.airlines.repositories.FlightRepository;
import com.airlines.repositories.UserRepository;

public class PaymentServiceImpl  implements PaymentService{
	
	private UserRepository userRepository;
	private FlightRepository flightRepository;
	
	

	public PaymentServiceImpl(UserRepository userRepository, FlightRepository flightRepository) {
		super();
		this.userRepository = userRepository;
		this.flightRepository = flightRepository;
	}



	@Override
	public String createPayment(Payment payment) {

		
	
		return null;
	}
	
	

}

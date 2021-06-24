package com.airlines.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.airlines.exception.UserNotFoundException;
import com.airlines.model.PassengerModel;

class PassengerServiceImplTest {

	@Mock
	PassengerServiceImpl passengerService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testPassenger() throws UserNotFoundException {
		PassengerModel passenger = new PassengerModel();

		passenger.setAddress("street,state");
		passenger.setAge(21);
		passenger.setEmailId("e@gmail.com");
		passenger.setGender("f");
		passenger.setMobileNumber(8247485634L);
		passenger.setPassengerName("anonymous");

		assertFalse(passengerService.addPassengers(passenger) != null);
	}
}

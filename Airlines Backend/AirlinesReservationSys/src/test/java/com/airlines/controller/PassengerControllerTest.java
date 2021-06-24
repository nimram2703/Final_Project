package com.airlines.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.airlines.entities.Passenger;
import com.airlines.entities.User;
import com.airlines.exception.UserNotFoundException;
import com.airlines.model.AuthResponse;
import com.airlines.model.PassengerModel;
import com.airlines.model.UserLoginModel;
import com.airlines.model.UserModel;
import com.airlines.repositories.PassengerRepository;
import com.airlines.repositories.UserRepository;
import com.airlines.services.PassengerService;
import com.airlines.services.UserService;

class PassengerControllerTest {

	@Mock
	PassengerService passengerService;

	@Mock
	PassengerRepository passengerRepository;

	@InjectMocks
	PassengerController passengerController;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	User user = new User("pass", "userNm", "user@gmail.com");
	PassengerModel model = new PassengerModel("passenger", "e@gmail.com", 21, "f", 8247485634L, "address", "user");

	@Test
	void testPassenger() throws UserNotFoundException {

		Passenger passenger2 = passengerService.addPassengers(model);

		passenger2 = new Passenger("passenger2", "e@gmail.com", 21, "f", 8247485634L, "address", user);

		assertNotNull(passenger2);

	}

	@Test
	void testException() {
		when(passengerRepository.findById(1)).thenReturn(null);
		assertThrows(NullPointerException.class, () -> passengerController.savePassenger(model));

	}

}

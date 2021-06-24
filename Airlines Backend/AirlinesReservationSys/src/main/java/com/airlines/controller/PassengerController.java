package com.airlines.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airlines.entities.Flight;
import com.airlines.entities.Passenger;
import com.airlines.exception.AirlinesException;
import com.airlines.exception.NoAccessException;
import com.airlines.exception.UserNotFoundException;
import com.airlines.model.PassengerModel;
import com.airlines.services.PassengerService;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
	
	private PassengerService passengerService;

	public PassengerController(PassengerService passengerService) {
		super();
		this.passengerService = passengerService;
	}
	
	
	
	@PostMapping("/save")
	public ResponseEntity<PassengerModel> savePassenger(@RequestBody PassengerModel passenger) throws UserNotFoundException {
		try {
			
			Passenger passenger2=passengerService.addPassengers(passenger);
			PassengerModel passengerModel=new PassengerModel();
			passenger.setPassengerName(passenger2.getPassengerName());
		return new ResponseEntity<PassengerModel> (passengerModel,HttpStatus.OK);
		}
		catch(UserNotFoundException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}

}

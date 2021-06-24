package com.airlines.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airlines.entities.Flight;
import com.airlines.entities.User;
import com.airlines.exception.AirlinesException;
import com.airlines.exception.FlightNotFoundException;
import com.airlines.exception.NoAccessException;
import com.airlines.exception.UserNotFoundException;
import com.airlines.model.AuthResponse;
import com.airlines.model.FlightModel;
import com.airlines.model.FlightResponse;
import com.airlines.model.SearchFlightModel;
import com.airlines.model.UserModel;
import com.airlines.services.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightsController {

	private FlightService flightService;

	public FlightsController(FlightService flightService) {
		super();
		this.flightService = flightService;
	}

	@PostMapping("/searchToBook")
	public ResponseEntity<List<FlightModel>> searchToBookFlight(@RequestBody SearchFlightModel flight) {
		List<FlightModel> displayflights=new ArrayList<>();
		try {
			List<Flight> flights=flightService.getAvailableFlights(flight);
			
			flights.forEach((Flight f)->{
				System.out.println(f.getFlightName()+"\t"+f.getDateOfTravel());
				FlightModel modelFlight=new FlightModel();
				modelFlight.setFlightId(f.getFlightId());
				modelFlight.setFlightname(f.getFlightName());
				modelFlight.setFromcity(f.getFromLocation());
				modelFlight.setTocity(f.getToLocation());
				modelFlight.setArrivaltime(f.getArrivalTime());
				modelFlight.setDeparturetime(f.getDepartureTime());
				modelFlight.setDate(f.getDateOfTravel());
				modelFlight.setPrice(f.getPrice());
				modelFlight.setTravelduration(f.getDuration());
				modelFlight.setNoOfSeats(f.getNoOfSeats());
				displayflights.add(modelFlight);
			});

			return new ResponseEntity<List<FlightModel>>(displayflights,HttpStatus.ACCEPTED);
		} catch (FlightNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/getFare")
	public ResponseEntity<Flight> getFareToBook(@PathVariable("userName") String userName,
			@RequestParam String classType, @PathVariable("id") int flightId, @RequestParam int noOfSeats) {
		try {
			flightService.gettotalFare(flightId, classType, noOfSeats, userName);
			return new ResponseEntity<Flight>(HttpStatus.OK);
		} catch (FlightNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/all")
	public ResponseEntity<List<Flight>> viewAllFlight() throws AirlinesException {
		
		List<Flight> flights = flightService.getAllFlight();
		return new ResponseEntity<>(flights, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<FlightModel> addFlights(@RequestBody FlightModel flight) throws AirlinesException {
		try {
			FlightModel newFlight = flightService.addFlight(flight);
			return new ResponseEntity<FlightModel>(newFlight, HttpStatus.CREATED);
		} catch (NoAccessException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}

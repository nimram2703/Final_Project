package com.airlines.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airlines.entities.Flight;
import com.airlines.entities.User;
import com.airlines.exception.FlightNotFoundException;
import com.airlines.exception.NoAccessException;
import com.airlines.model.FlightModel;
import com.airlines.model.SearchFlightModel;
import com.airlines.repositories.FlightRepository;
import com.airlines.repositories.UserRepository;

@Service
public class FlightServiceImpl implements FlightService {

	private UserRepository userRepository;
	private FlightRepository flightRepository;

	public FlightServiceImpl(UserRepository userRepository, FlightRepository flightRepository) {
		super();
		this.userRepository = userRepository;
		this.flightRepository = flightRepository;
	}
	

	@Override
	public List<Flight> getAvailableFlights(SearchFlightModel flight) throws FlightNotFoundException {
		System.out.println(flight.getSource()+"\t"+
						flight.getDestination()+"\t" +flight.getDate()+"\t"+ flight.getNumber()+"\t"+ flight.getClasstype());
		return flightRepository
				.getAvailableFlights(flight.getSource(),
						flight.getDestination(), flight.getDate(), flight.getNumber(), flight.getClasstype());

	}

	@Override
	public List<Flight> getAllFlight() {
		
		return flightRepository.findAll();
	}

	@Override
	public FlightModel addFlight(FlightModel flightModel) throws NoAccessException {
		Flight flight=new Flight();
		flight.setFlightName(flightModel.getFlightname());
		flight.setFromLocation(flightModel.getFromcity());
		flight.setToLocation(flightModel.getTocity());
		flight.setArrivalTime(flightModel.getArrivaltime());
		flight.setDepartureTime(flightModel.getDeparturetime());
		flight.setDateOfTravel(flightModel.getDate());
		flight.setBusinessClassFare(flightModel.getBusinessClassFare());
		flight.setEconomyClassFare(flightModel.getEconomyClassFare());
		flight.setDuration(flightModel.getTravelduration());
		flight.setClassType(flightModel.getClasstype());
		flight.setPrice(flightModel.getPrice());
		flight.setNoOfSeats(flightModel.getNoOfSeats());


		User user = userRepository.findByUserName(flightModel.getUsername());
		System.out.println(user.getUserName());
		if (user.getUserRole().equals("admin")) {
			user.addFlight(flight);
			flight.setUser(user);
			flightRepository.save(flight);
			return flightModel;

		} else {
			throw new NoAccessException("Admin Not Found/ You are not having access to perform this operation");
		}

	}


	  public double gettotalFare(int flightId, String classType, int noOfSeats,
	  String userName) throws FlightNotFoundException {

			
		  return 0;
	  }

}

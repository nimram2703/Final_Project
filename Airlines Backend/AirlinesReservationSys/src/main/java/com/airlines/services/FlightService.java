package com.airlines.services;

import java.util.List;

import com.airlines.entities.Flight;
import com.airlines.exception.FlightNotFoundException;
import com.airlines.exception.NoAccessException;
import com.airlines.model.FlightModel;
import com.airlines.model.SearchFlightModel;

public interface FlightService  {

	
	public List<Flight> getAvailableFlights(SearchFlightModel flight) throws FlightNotFoundException;
	public double gettotalFare(int flightId, String classType, int noOfSeats, String userName) throws FlightNotFoundException;
	public FlightModel addFlight(FlightModel flight) throws NoAccessException;
	public List<Flight> getAllFlight();
	
}

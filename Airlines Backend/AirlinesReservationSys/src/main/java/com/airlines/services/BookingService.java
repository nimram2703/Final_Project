package com.airlines.services;
import com.airlines.entities.*;


public interface BookingService {
	public BookingInfo book(Passenger passenger, Flight flight, Payment payment, User user,BookingInfo bookingInfo);

}
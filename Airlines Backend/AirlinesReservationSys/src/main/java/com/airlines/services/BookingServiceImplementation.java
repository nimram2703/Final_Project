package com.airlines.services;

import org.springframework.stereotype.Service;

import com.airlines.entities.BookingInfo;
import com.airlines.entities.Flight;
import com.airlines.entities.Passenger;
import com.airlines.entities.Payment;
import com.airlines.entities.User;
import com.airlines.repositories.BookingInfoRepository;
import com.airlines.repositories.FlightRepository;
import com.airlines.repositories.PassengerRepository;
import com.airlines.repositories.PaymentRepository;
import com.airlines.repositories.UserRepository;

@Service
public class BookingServiceImplementation implements BookingService {

	BookingInfoRepository bookingInfoRepository;
	UserRepository userRepository;
	PaymentRepository paymentRepository;
	FlightRepository flightRepository;
	PassengerRepository passengerRepository;

	public BookingServiceImplementation(BookingInfoRepository bookingInfoRepository, UserRepository userRepository,
			PaymentRepository paymentRepository, FlightRepository flightRepository,PassengerRepository passengerRepository) {
		super();
		this.bookingInfoRepository = bookingInfoRepository;
		this.userRepository = userRepository;
		this.paymentRepository = paymentRepository;
		this.flightRepository = flightRepository;
		this.passengerRepository=passengerRepository;
	}


	@Override
	public BookingInfo book(Passenger passenger, Flight flight, Payment payment, User user,BookingInfo bookingInfo) {
		passenger.setUser(user);
		passengerRepository.save(passenger);
		flight.setUser(user);
		payment.setUser(user);
		payment.setBooking(bookingInfo);
		paymentRepository.save(payment);
		bookingInfo.setUser(user);
		bookingInfo.setFlights(flight);
		bookingInfo.setPayment(payment);
		user.addBooking(bookingInfo);
		user.addFlight(flight);
		user.addPassenger(passenger);
		bookingInfoRepository.save(bookingInfo);

		return  bookingInfo;

	}
}

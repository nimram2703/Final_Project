package com.airlines.controller;

import com.airlines.entities.*;
import com.airlines.model.BookingInfoModel;
import com.airlines.model.BookingReport;
import com.airlines.repositories.FlightRepository;
import com.airlines.repositories.PaymentRepository;
import com.airlines.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airlines.repositories.BookingInfoRepository;
import com.airlines.services.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	private BookingService bookingService;

	private BookingInfoRepository bookingInfoRepository;
	private UserRepository userRepository;
	private FlightRepository flightRepository;
	private PaymentRepository paymentRepository;

	public BookingController(BookingService bookingService, BookingInfoRepository bookingInfoRepository, UserRepository userRepository, FlightRepository flightRepository,PaymentRepository paymentRepository) {
		this.bookingService = bookingService;
		this.bookingInfoRepository = bookingInfoRepository;
		this.userRepository = userRepository;
		this.flightRepository = flightRepository;
		this.paymentRepository=paymentRepository;
	}

	@PostMapping("/book")
	public ResponseEntity<BookingReport> bookingInfo(@RequestBody BookingInfoModel booking) {

		System.out.println(booking.getExpiryMonth()+"\t"+booking.getPaymentDate()+"\t"+booking.getExpiryYear());
		User user=userRepository.findByUserName(booking.getUserName());
		Flight flight=flightRepository.findByFlightId(booking.getFlightId());
		Passenger passenger=new Passenger();
		passenger.setPassengerName(booking.getPassengerName());
		passenger.setAddress(booking.getAddress());
		passenger.setEmailId(booking.getEmailId());
		passenger.setAge(booking.getAge());
		passenger.setGender(booking.getGender());
		passenger.setMobileNumber(booking.getMobileNumber());

		Payment payment=new Payment();
		payment.setPaymentDate(booking.getPaymentDate());
		payment.setCardNo(booking.getCardNo());
		payment.setCardHolderName(booking.getCardHolderName());
		payment.setExpiryMonth(booking.getExpiryMonth());
		payment.setExpiryYear(booking.getExpiryYear());
		BookingInfo bookingInfo=new BookingInfo();
		bookingInfo.setBookingDate(booking.getBookingDate());
		bookingInfo.setBookingStatus(booking.getBookingStatus());
		bookingInfo.setBookingTime(booking.getBookingTime());
		bookingInfo.setBookingDate(booking.getBookingDate());
		bookingInfo.setNoOfPassengers(booking.getNoOfPassengers());
		BookingInfo bookingInfo1=this.bookingService.book(passenger,flight,payment,user,bookingInfo);
		BookingReport bookingReport=new BookingReport();
		bookingReport.setCardHolderName(booking.getCardHolderName());
		bookingReport.setBookingDate(booking.getBookingDate());
		bookingReport.setBookingTime(booking.getBookingTime());
		bookingReport.setPaymentDate(booking.getPaymentDate());
		bookingReport.setAddress(booking.getAddress());
		bookingReport.setPassengerName(passenger.getPassengerName());
		bookingReport.setDepartureTime(flight.getDepartureTime());
		bookingReport.setArrivalTime(flight.getArrivalTime());
		bookingReport.setBookieName(user.getUserName());
		bookingReport.setBookingStatus(booking.getBookingStatus());
		bookingReport.setFlightName(flight.getFlightName());
		bookingReport.setFromLocation(flight.getFromLocation());
		bookingReport.setToLocation(flight.getToLocation());
		bookingReport.setPrice(flight.getPrice());
		return  new ResponseEntity<BookingReport>(bookingReport,HttpStatus.CREATED);
	}

}
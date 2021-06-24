package com.airlines.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.airlines.model.BookingReport;
import com.airlines.repositories.BookingInfoRepository;

class BookingServiceImplementationTest {

	@Mock
	BookingInfoRepository bookingInfoRepository;

	@InjectMocks
	BookingService bookingService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testBook() {
		BookingReport booking = new BookingReport();
		booking.setBookingDate(LocalDate.parse("2021-06-21"));
		booking.setBookingStatus("booked");
		booking.setAddress("adddress");
		booking.setArrivalTime(LocalTime.parse("10:30:00"));
		booking.setBookieName("bookieX");
		booking.setBookingDate(LocalDate.parse("2021-03-22"));

		booking.setBookingTime("5:30");
		booking.setCardHolderName("holder");
		booking.setDepartureTime(LocalTime.parse("09:30:00"));
		booking.setFlightName("airasia");
		booking.setFromLocation("hyderabad");
		booking.setPassengerName("passengerX");
		booking.setPaymentDate(LocalDate.parse("2021-03-22"));
		booking.setPrice(2300);
		booking.setToLocation("mumbai");

		assertTrue(booking != null);
	}

}

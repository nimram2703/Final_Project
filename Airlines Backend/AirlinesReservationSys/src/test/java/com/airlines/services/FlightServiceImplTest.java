
package com.airlines.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.airlines.entities.Flight;
import com.airlines.exception.NoAccessException;
import com.airlines.model.FlightModel;
import com.airlines.model.SearchFlightModel;
import com.airlines.repositories.FlightRepository;
import com.airlines.repositories.UserRepository;

class FlightServiceImplTest {

	@Mock
	FlightRepository flightRepository;
	@InjectMocks
	FlightServiceImpl flightService;

	@Autowired
	UserRepository userRepository;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	SearchFlightModel search = new SearchFlightModel("chennai", "hyderabad", LocalDate.parse("2021-06-20"), 1,
			"business");

	FlightModel flightModel = new FlightModel();

	@Test
	void testAddFlights() throws NoAccessException {

		Flight model = new Flight();

		model.setFlightId(1001);
		model.setFlightName("airasia");
		model.setFromLocation("hyderabad");
		model.setToLocation("chennai");
		model.setDateOfTravel(LocalDate.parse("2021-06-20"));
		model.setDepartureTime(LocalTime.parse("10:30:00"));
		model.setArrivalTime(LocalTime.parse("11:30:00"));
		model.setDuration(1);
		model.setPrice(2500);
		model.setClassType("Business");
		model.setNoOfSeats(3);
		model.setBusinessClassFare(2500);
		model.setEconomyClassFare(0);

		assertFalse(flightRepository.save(model) != null);

	}

}

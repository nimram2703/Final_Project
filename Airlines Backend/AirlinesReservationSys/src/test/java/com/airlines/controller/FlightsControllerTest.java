package com.airlines.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.airlines.entities.Flight;
import com.airlines.entities.User;
import com.airlines.exception.AirlinesException;
import com.airlines.exception.FlightNotFoundException;
import com.airlines.exception.NoAccessException;
import com.airlines.exception.UserNotFoundException;
import com.airlines.model.AuthResponse;
import com.airlines.model.FlightModel;
import com.airlines.model.SearchFlightModel;
import com.airlines.repositories.FlightRepository;
import com.airlines.repositories.UserRepository;
import com.airlines.services.FlightServiceImpl;

class FlightsControllerTest {

	@Mock
	FlightRepository flightRepository;

	@Mock
	FlightServiceImpl flightService;

	@InjectMocks
	FlightsController controller;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	SearchFlightModel search = new SearchFlightModel("chennai", "hyderabad", LocalDate.parse("2021-06-20"), 1,
			"business");

	FlightModel model = new FlightModel(1, "name", "from", "to", LocalDate.parse("2021-06-20"),
			LocalTime.parse("11:30:00"), LocalTime.parse("10:30:00"), 1, 2500, "business", 0, 2500, 0, "userName");

	Flight f = new Flight("name", "from", "to", LocalTime.parse("11:30:00"), LocalTime.parse("10:30:00"), 1, 2500,
			"business", 0, 0, LocalDate.parse("2021-06-20"), 0, 0, 2500, 0, new User());

	Flight f2 = new Flight("name1", "from1", "to1", LocalTime.parse("12:30:00"), LocalTime.parse("13:30:00"), 1, 2500,
			"business", 0, 0, LocalDate.parse("2021-06-20"), 0, 0, 2500, 0, new User());

	List<Flight> flightList = new ArrayList<Flight>();

	@Test
	void testFlights() throws NoAccessException, AirlinesException {

		when(flightService.addFlight(model)).thenReturn(model);
		ResponseEntity<FlightModel> model2 = controller.addFlights(model);
		assertNotNull(model2);

	}

	@Test
	void testAllFlight() throws AirlinesException {
		flightList.add(f);
		flightList.add(f2);

		when(flightService.getAllFlight()).thenReturn(flightList);
		ResponseEntity<List<Flight>> list2 = controller.viewAllFlight();
		assertNotNull(list2);
	}

	@Test
	void testAvailableFlights() throws FlightNotFoundException {

		when(flightService.getAvailableFlights(search)).thenReturn(flightList);
		ResponseEntity<List<FlightModel>> flightModel = controller.searchToBookFlight(search);
		assertNotNull(flightModel);
	}

	@Test
	void testFare() throws FlightNotFoundException {
		when(flightService.gettotalFare(1, "business", 1, "userName")).thenReturn((double) 2500);
		ResponseEntity<Flight> flight1 = controller.getFareToBook("userName", "business", 1, 1);
		assertNotNull(flight1);
	}

}

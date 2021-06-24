package com.airlines.repositories;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.airlines.entities.Flight;
import com.airlines.entities.User;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
	//User findByUserNameAndPassword(String userName,String password);//select u from User u where u.userName=1? and password=2?;
	@Query(value = "select * from flight where from_location=?1 and to_location=?2 and date_of_travel=?3 and no_of_seats=?4 and class_type=?5",nativeQuery = true)
	List<Flight> getAvailableFlights(String fromLocation,String toLocation,LocalDate dateOfTravel,int noOfSeats,String classType);
	Flight findByFlightId(int flightId);

}


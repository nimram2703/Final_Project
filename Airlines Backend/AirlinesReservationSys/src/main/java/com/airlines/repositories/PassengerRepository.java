package com.airlines.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airlines.entities.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

	
}

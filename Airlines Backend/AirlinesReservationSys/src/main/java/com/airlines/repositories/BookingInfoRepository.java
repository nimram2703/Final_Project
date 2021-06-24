package com.airlines.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airlines.entities.BookingInfo;


@Repository
public interface BookingInfoRepository extends JpaRepository<BookingInfo, Integer> {
	
}
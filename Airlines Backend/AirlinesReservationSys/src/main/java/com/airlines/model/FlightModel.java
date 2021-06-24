package com.airlines.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class FlightModel {
    private int flightId;
    private String flightname;
    private String fromcity;
    private String tocity;
    private LocalDate date;
    private LocalTime departuretime;
    private LocalTime arrivaltime;
    private int travelduration;
    private int price;
    private String classtype;
    private int businessClassFare;
    private int EconomyClassFare;
    private int noOfSeats;
    private String username;

    public FlightModel() {
        // TODO Auto-generated constructor stub
    }

    public String getFlightname() {
        return flightname;
    }

    public void setFlightname(String flightname) {
        this.flightname = flightname;
    }

    public String getFromcity() {
        return fromcity;
    }

    public void setFromcity(String fromcity) {
        this.fromcity = fromcity;
    }

    public String getTocity() {
        return tocity;
    }

    public void setTocity(String tocity) {
        this.tocity = tocity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(LocalTime departuretime) {
        this.departuretime = departuretime;
    }

    public LocalTime getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(LocalTime arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public int getTravelduration() {
        return travelduration;
    }

    public void setTravelduration(int travelduration) {
        this.travelduration = travelduration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getClasstype() {
        return classtype;
    }

    public void setClasstype(String classtype) {
        this.classtype = classtype;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBusinessClassFare() {
        return businessClassFare;
    }

    public void setBusinessClassFare(int businessClassFare) {
        this.businessClassFare = businessClassFare;
    }

    public int getEconomyClassFare() {
        return EconomyClassFare;
    }

    public void setEconomyClassFare(int economyClassFare) {
        EconomyClassFare = economyClassFare;
    }

    public int getFlightId() {
        return flightId;
    }
    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

	public FlightModel(int flightId, String flightname, String fromcity, String tocity, LocalDate date,
			LocalTime departuretime, LocalTime arrivaltime, int travelduration, int price, String classtype,
			int businessClassFare, int economyClassFare, int noOfSeats, String username) {
		super();
		this.flightId = flightId;
		this.flightname = flightname;
		this.fromcity = fromcity;
		this.tocity = tocity;
		this.date = date;
		this.departuretime = departuretime;
		this.arrivaltime = arrivaltime;
		this.travelduration = travelduration;
		this.price = price;
		this.classtype = classtype;
		this.businessClassFare = businessClassFare;
		EconomyClassFare = economyClassFare;
		this.noOfSeats = noOfSeats;
		this.username = username;
	}
    
}

package com.airlines.model;

import java.time.LocalDate;

public class SearchFlightModel {
	private String source;
	private String destination;
	private LocalDate date;
	private int number;
	private String classtype;
	public SearchFlightModel() {
		// TODO Auto-generated constructor stub
	}
	public SearchFlightModel(String source, String destination, LocalDate date, int number, String classtype) {
		super();
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.number = number;
		this.classtype = classtype;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getClasstype() {
		return classtype;
	}
	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}	
}

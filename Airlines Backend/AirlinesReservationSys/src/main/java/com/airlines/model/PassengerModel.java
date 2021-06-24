package com.airlines.model;

public class PassengerModel {
	private String passengerName;
	private String emailId;
	private int age;
	private String gender;
	private long mobileNumber;
	private String address;
	private String username;
	public PassengerModel() {
		// TODO Auto-generated constructor stub
	}
	public PassengerModel(String passengerName, String emailId, int age, String gender, long mobileNumber,
			String address, String username) {
		super();
		this.passengerName = passengerName;
		this.emailId = emailId;
		this.age = age;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.username = username;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}

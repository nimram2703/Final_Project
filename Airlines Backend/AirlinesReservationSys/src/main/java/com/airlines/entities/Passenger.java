package com.airlines.entities;

import javax.persistence.*;

@Entity
public class Passenger {

	



	@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int passengerId;
		private String passengerName;
		private String emailId;
		private int age;
		private String gender;
		private long mobileNumber;
		private String address;
		@ManyToOne(cascade = {CascadeType.PERSIST})
		@JoinColumn(name = "userId")
		private User user;
		public Passenger() {
			// TODO Auto-generated constructor stub
		}
		public int getPassengerId() {
			return passengerId;
		}

		public void setPassengerId(int passengerId) {
			this.passengerId = passengerId;
		}

	

		public Passenger(int passengerId, String passengerName, String emailId, int age, String gender,
				long mobileNumber, String address, User user) {
			super();
			this.passengerId = passengerId;
			this.passengerName = passengerName;
			this.emailId = emailId;
			this.age = age;
			this.gender = gender;
			this.mobileNumber = mobileNumber;
			this.address = address;
			this.user = user;
		}



		/*public int getNoOfPassengers() {
			return noOfPassengers;
		}

		public void setNoOfPassengers(int noOfPassengers) {
			this.noOfPassengers = noOfPassengers;
		}*/

		public String getPassengerName() {
			return passengerName;
		}



		public void setPassengerName(String passengerName) {
			this.passengerName = passengerName;
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



		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
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

		public Passenger(String passengerName, String emailId, int age, String gender, long mobileNumber, String address,
				User user) {
			super();
			this.passengerName = passengerName;
			this.emailId = emailId;
			this.age = age;
			this.gender = gender;
			this.mobileNumber = mobileNumber;
			this.address = address;
			this.user = user;
		}

	
		
	

}

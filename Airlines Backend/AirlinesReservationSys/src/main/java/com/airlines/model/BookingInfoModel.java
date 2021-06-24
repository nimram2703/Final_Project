package com.airlines.model;

import java.time.LocalDate;

public class BookingInfoModel {
    private int flightId;
    private LocalDate bookingDate;
    private String bookingTime;
    private int noOfPassengers;
    private String bookingStatus;
    private String userName;
    private LocalDate paymentDate;
    private long cardNo;
    private String cardHolderName;
    private int expiryYear;
    private int expiryMonth;
    private String passengerName;
    private String emailId;
    private int age;
    private String gender;
    private long mobileNumber;
    private String address;

    public BookingInfoModel() {
    }

    public BookingInfoModel(int flightId, LocalDate bookingDate, String bookingTime, int noOfPassengers, String bookingStatus, String userName, LocalDate paymentDate, long cardNo, String cardHolderName, int expiryYear, int expiryMonth, String passengerName, String emailId, int age, String gender, long mobileNumber, String address) {
        this.flightId = flightId;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.noOfPassengers = noOfPassengers;
        this.bookingStatus = bookingStatus;
        this.userName = userName;
        this.paymentDate = paymentDate;
        this.cardNo = cardNo;
        this.cardHolderName = cardHolderName;
        this.expiryYear = expiryYear;
        this.expiryMonth = expiryMonth;
        this.passengerName = passengerName;
        this.emailId = emailId;
        this.age = age;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.address = address;
    }

    public BookingInfoModel(int flightId, LocalDate bookingDate, String bookingTime, int noOfPassengers, String bookingStatus, String userName, LocalDate paymentDate, long cardNo, String cardHolderName, int expiryYear, int expiryMonth) {
        this.flightId = flightId;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.noOfPassengers = noOfPassengers;
        this.bookingStatus = bookingStatus;
        this.userName = userName;
        this.paymentDate = paymentDate;
        this.cardNo = cardNo;
        this.cardHolderName = cardHolderName;
        this.expiryYear = expiryYear;
        this.expiryMonth = expiryMonth;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public long getCardNo() {
        return cardNo;
    }

    public void setCardNo(long cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(int expiryMonth) {
        this.expiryMonth = expiryMonth;
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

    @Override
    public String toString() {
        return "BookingInfoModel{" +
                "flightId=" + flightId +
                ", bookingDate=" + bookingDate +
                ", bookingTime='" + bookingTime + '\'' +
                ", noOfPassengers=" + noOfPassengers +
                ", bookingStatus='" + bookingStatus + '\'' +
                ", userName='" + userName + '\'' +
                ", paymentDate=" + paymentDate +
                ", cardNo=" + cardNo +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", expiryYear=" + expiryYear +
                ", expiryMonth=" + expiryMonth +
                ", passengerName='" + passengerName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", address='" + address + '\'' +
                '}';
    }
}

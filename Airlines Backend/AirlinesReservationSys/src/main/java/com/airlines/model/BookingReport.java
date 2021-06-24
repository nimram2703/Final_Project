package com.airlines.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingReport {
    private String cardHolderName;
    private String bookieName;
    private String address;
    private LocalDate bookingDate;
    private String bookingTime;
    private LocalDate paymentDate;
    private LocalTime arrivalTime;
    private LocalTime departureTime;
    private String passengerName;
    private String bookingStatus;
    private String flightName;
    private String fromLocation;
    private String toLocation;
    private int price;

    public BookingReport() {
    }

    public BookingReport(String cardHolderName, String bookieName, String address, LocalDate bookingDate, String bookingTime, LocalDate paymentDate, LocalTime arrivalTime, LocalTime departureTime, String passengerName, String bookingStatus, String flightName) {
        this.cardHolderName = cardHolderName;
        this.bookieName = bookieName;
        this.address = address;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.paymentDate = paymentDate;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.passengerName = passengerName;
        this.bookingStatus = bookingStatus;
        this.flightName = flightName;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getBookieName() {
        return bookieName;
    }

    public void setBookieName(String bookieName) {
        this.bookieName = bookieName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

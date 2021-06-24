package com.airlines.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	private LocalDate paymentDate;
	private long cardNo;
	private String cardHolderName;
	private int expiryYear;
	private int expiryMonth;

	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "userId")
	private User user;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookingId")
	private BookingInfo booking;

	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BookingInfo getBooking() {
		return booking;
	}

	public void setBooking(BookingInfo booking) {
		this.booking = booking;
	}

	public Payment(int paymentId, LocalDate paymentDate, long cardNo, String cardHolderName, int expiryYear, int expiryMonth,
			User user, BookingInfo booking) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.cardNo = cardNo;
		this.cardHolderName = cardHolderName;
		this.expiryYear = expiryYear;
		this.expiryMonth = expiryMonth;
		this.user = user;
		this.booking = booking;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Payment(int paymentId, LocalDate paymentDate, long cardNo, String cardHolderName, int expiryYear,
			int expiryMonth) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.cardNo = cardNo;
		this.cardHolderName = cardHolderName;
		this.expiryYear = expiryYear;
		this.expiryMonth = expiryMonth;
	}


}

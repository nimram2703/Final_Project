import { Payment } from './payment.model';

export class BookingInfo {
  bookingId: number;
  bookingDate: Date;
  bookingTime: string;
  noOfPassengers: number;
  bookingStatus: string;
  flightId: number;
  userName: string;
  paymentDate: Date;
  cardNo: string;
  cardHolderName: string;
  expiryYear: number;
  expiryMonth: number;
  passengerName: string;
  emailId: string;
  age: number;
  gender: string;
  mobileNumber: number;
  address: string;

  constructor(
    flightId: number,
    bookingDate: Date,
    bookingTime: string,
    noOfPassengers: number,
    bookingStatus: string,
    userName: string,
    paymentDate: Date,
    cardNo: string,
    cardHolderName: string,
    expiryYear: number,
    expiryMonth: number,
    passengerName: string,
    emailId: string,
    age: number,
    gender: string,
    mobileNumber: number,
    address: string
  ) {
    this.flightId = flightId;
    this.bookingDate = bookingDate;
    this.bookingTime = bookingTime;
    this.bookingStatus = bookingStatus;
    this.noOfPassengers = noOfPassengers;
    this.userName = userName;
    this.paymentDate = paymentDate;
    this.cardNo = cardNo;
    this.cardHolderName = cardHolderName;
    this.expiryYear = expiryYear;
    this.expiryMonth = expiryMonth;
    this.passengerName = passengerName;
    this.address = address;
    this.emailId = emailId;
    this.gender = gender;
    this.age = age;
    this.mobileNumber = mobileNumber;
  }
}

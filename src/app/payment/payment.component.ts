import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BookingService } from '../shared/booking.service';
import { BookingInfo } from '../shared/bookingInfo.model';
import { BookingReport } from '../shared/bookingreport.model';
import { Flight } from '../shared/flight.model';
import { Passenger } from '../shared/passenger.model';
import { Payment } from '../shared/payment.model';
import { User } from '../shared/user.model';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css'],
})
export class PaymentComponent implements OnInit {
  PaymentForm: FormGroup;
  payment: Payment;
  user: User;
  flight: Flight;
  passenger: Passenger;
  bookingData: BookingReport;
  constructor(private router: Router, private bookingService: BookingService) {
    this.PaymentForm = new FormGroup({
      cardNo: new FormControl(null, [Validators.required]),
      cardHolderName: new FormControl(null, [Validators.required]),
      expiryMonth: new FormControl(null, [Validators.required]),
      expiryYear: new FormControl(null, [Validators.required]),
      cvvNo: new FormControl(null, [
        Validators.required,
        Validators.minLength(3),
      ]),
    });
  }

  ngOnInit(): void {}

  onSubmit() {
    let user: User = JSON.parse(localStorage.getItem('user'));
    let flight: Flight = JSON.parse(localStorage.getItem('flight'));
    this.user = user;
    this.flight = flight;
    this.passenger = JSON.parse(localStorage.getItem('passenger'));
    this.payment = this.PaymentForm.value;
    let bookinginfo = new BookingInfo(
      this.flight.flightId,
      new Date(),
      new Date().toLocaleString('en-US', {
        hour: 'numeric',
        hour12: true,
      }),
      flight.noOfSeats,
      'booked',
      this.user.userName,
      new Date(),
      this.payment.cardNo,
      this.payment.cardHolderName,
      this.payment.expiryYear,
      this.payment.expiryMonth,
      this.passenger.passengerName,
      this.passenger.emailId,
      this.passenger.age,
      this.passenger.gender,
      this.passenger.mobileNumber,
      this.passenger.address
    );
    console.log(this.user);
    console.log(this.flight);

    this.bookingService.book(bookinginfo).subscribe((response) => {
      //this.bookingData = response;
      console.log(response);
      localStorage.setItem('bookingData', JSON.stringify(response));
      this.router.navigate(['bookinginfo']);
    });
  }
}

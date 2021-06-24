import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthResponse } from '../shared/AuthResonse.model';
import { Flight } from '../shared/flight.model';
import { FlightService } from '../shared/flight.service';
import { Passenger } from '../shared/passenger.model';
import { PassengerService } from '../shared/passenger.service';

@Component({
  selector: 'app-passengers',
  templateUrl: './passengers.component.html',
  styleUrls: ['./passengers.component.css'],
})
export class PassengersComponent implements OnInit {
  PassengerForm: FormGroup;
  user: AuthResponse;
  flight: Flight;
  passenger: Passenger;
  constructor(
    private router: Router,
    private passengerService: PassengerService,
    private flightService: FlightService
  ) {
    this.PassengerForm = new FormGroup({
      passengerName: new FormControl(null, [Validators.required]),
      mobileNumber: new FormControl(null, [
        Validators.required,
        Validators.pattern('[789][0-9]{9}'),
      ]),
      age: new FormControl(null, [Validators.required]),
      emailId: new FormControl(null, [Validators.required, Validators.email]),
      gender: new FormControl(null, [Validators.required]),
      address: new FormControl(null, [Validators.required]),
    });
  }

  ngOnInit(): void {}

  onSubmit() {
    this.user = JSON.parse(localStorage.getItem('user'));
    this.passenger = this.PassengerForm.value;
    this.flight = JSON.parse(localStorage.getItem('flight'));
    localStorage.setItem('passenger', JSON.stringify(this.passenger));
    this.router.navigate(['payment']);
  }
}

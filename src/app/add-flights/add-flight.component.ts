import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthResponse } from '../shared/AuthResonse.model';
import { Flight } from '../shared/flight.model';
import { FlightService } from '../shared/flight.service';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css'],
})
export class AddFlightComponent implements OnInit {
  AddFlightsForm: FormGroup;
  isFlightAdded: boolean = false;
  user: AuthResponse;
  constructor(private router: Router, private flightService: FlightService) {
    this.AddFlightsForm = new FormGroup({
      flightname: new FormControl(null, [Validators.required]),
      fromcity: new FormControl(null, [Validators.required]),
      tocity: new FormControl(null, [Validators.required]),
      date: new FormControl(null, [Validators.required]),
      departuretime: new FormControl(null, [Validators.required]),
      arrivaltime: new FormControl(null, [Validators.required]),
      travelduration: new FormControl(null, [Validators.required]),
      price: new FormControl(null, [Validators.required]),
      noOfSeats: new FormControl(null, [Validators.required]),
      classtype: new FormControl(null, [Validators.required]),
    });
  }

  ngOnInit(): void {}

  onSubmit() {
    this.user = JSON.parse(localStorage.getItem('user'));
    if (this.user.authenticationStatus) {
      let flight: Flight = this.AddFlightsForm.value;
      if ((flight.classType = 'Business Class')) {
        flight.businessClassFare = flight.price;
        flight.price = flight.businessClassFare * flight.noOfSeats;
      } else{
        flight.EconomyClassFare = flight.price;
        flight.price = flight.EconomyClassFare * flight.noOfSeats;
      }
      console.log(flight);
      this.flightService.bookFlight(flight, this.user).subscribe(
        (response) => {
          this.isFlightAdded = true;
          console.log(response);
        },
        (error) => {
          console.log(error);
        }
      );
      this.AddFlightsForm.reset();
    }
    console.log(this.AddFlightsForm.value);
  }
}

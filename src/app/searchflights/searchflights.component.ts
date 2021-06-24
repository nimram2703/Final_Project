import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Flight } from '../shared/flight.model';
import { FlightService } from '../shared/flight.service';
import { User } from '../shared/user.model';

@Component({
  selector: 'app-searchflights',
  templateUrl: './searchflights.component.html',
  styleUrls: ['./searchflights.component.css'],
})
export class SearchflightsComponent implements OnInit {
  SearchFlights: FormGroup;
  flights: Flight[] = null;
  isFlightsDisplayed: boolean = false;
  constructor(private router: Router, private flightService: FlightService) {
    this.SearchFlights = new FormGroup({
      source: new FormControl(null, [Validators.required]),
      destination: new FormControl(null, [Validators.required]),
      date: new FormControl(null, [Validators.required]),
      number: new FormControl(null, [Validators.required]),
      classtype: new FormControl(null),
    });
  }

  ngOnInit(): void {}

  onSubmit() {
    this.flightService
      .getAllFlights(this.SearchFlights.value)
      .subscribe((response) => {
        this.isFlightsDisplayed = true;
        console.log(response);
        this.flights = response;
        console.log(this.flights);
      });
  }
  onBook(flight: Flight) {
    let user: User = JSON.parse(localStorage.getItem('user'));
    flight.username = user.userName;
    //this.flightService.bookFlightEvent.emit(flight);
    localStorage.setItem('flight', JSON.stringify(flight));
    this.router.navigate(['passengers']);
  }
}

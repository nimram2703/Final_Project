import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent implements OnInit {
  AddFlightsForm: FormGroup;
  
  constructor(private router: Router) {
    this.AddFlightsForm = new FormGroup({

    flightno: new FormControl(null, [Validators.required]),
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
    })
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.AddFlightsForm.value);
  }

}

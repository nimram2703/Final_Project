import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-passengers',
  templateUrl: './passengers.component.html',
  styleUrls: ['./passengers.component.css']
})
export class PassengersComponent implements OnInit {

  PassengerForm: FormGroup;

  constructor(private router: Router) { 
    this.PassengerForm = new FormGroup({
      name: new FormControl(null, [Validators.required]),
      phoneno: new FormControl(null, [Validators.required, Validators.pattern("[789][0-9]{9}")]),
      email: new FormControl(null, [Validators.required, Validators.email]),
      gender: new FormControl(null, [Validators.required]),
  });
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.PassengerForm.value);
  }

  onLoad(){
    this.router.navigate(['payment'])
  }
  

}

import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-searchflights',
  templateUrl: './searchflights.component.html',
  styleUrls: ['./searchflights.component.css']
})
export class SearchflightsComponent implements OnInit {
 
  SearchFlights: FormGroup;
  constructor(private router: Router) { 
    this.SearchFlights = new FormGroup({
      source: new FormControl(null, [Validators.required]),
      destination: new FormControl(null, [Validators.required]),
      date: new FormControl(null, [Validators.required]),
      number: new FormControl(null, [Validators.required]),
  });
}

  ngOnInit(): void {
  }

  onLoad(){
    this.router.navigate(['displayflights'])
  }

  onSubmit() {
    console.log(this.SearchFlights.value);
  }

}

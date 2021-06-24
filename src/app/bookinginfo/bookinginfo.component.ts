import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { BookingReport } from '../shared/bookingreport.model';

@Component({
  selector: 'app-bookinginfo',
  templateUrl: './bookinginfo.component.html',
  styleUrls: ['./bookinginfo.component.css'],
})
export class BookinginfoComponent implements OnInit {
  bookingData: BookingReport;
  constructor() {}

  ngOnInit(): void {
    this.bookingData = JSON.parse(localStorage.getItem('bookingData'));
    console.log(this.bookingData);
  }
}

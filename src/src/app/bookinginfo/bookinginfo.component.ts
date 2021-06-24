import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-bookinginfo',
  templateUrl: './bookinginfo.component.html',
  styleUrls: ['./bookinginfo.component.css']
})
export class BookinginfoComponent implements OnInit {
  BookingInfoForm : FormGroup
  constructor() { }

  ngOnInit(): void {
  }

}

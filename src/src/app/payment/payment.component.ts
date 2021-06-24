import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  PaymentForm: FormGroup;

  constructor(private router: Router) {
    this.PaymentForm = new FormGroup({
      cardNo: new FormControl(null, [Validators.required]),
      name: new FormControl(null, [Validators.required]),
      expiryMonth: new FormControl(null, [Validators.required]),
      expiryYear: new FormControl(null, [Validators.required]),
      cvvNo: new FormControl(null, [Validators.required,Validators.minLength(3)])
   });

  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.PaymentForm.value);
  }

  onLoad() {
    this.router.navigate(['bookingInfo']);
    //this.router.navigate(['passengers']);
    
  }

  


}

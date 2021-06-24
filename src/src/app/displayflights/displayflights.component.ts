import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-displayflights',
  templateUrl: './displayflights.component.html',
  styleUrls: ['./displayflights.component.css']
})
export class DisplayflightsComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onLoad(){
    this.router.navigate(['passengers'])
  }

}

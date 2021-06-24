import { Component, OnInit } from '@angular/core';
import { UserService } from '../shared/users.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  isAdmin: boolean = false;
  isLoggedIn: boolean = false;
  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.userService.adminEvent.subscribe((isAdmin) => {
      this.isAdmin = isAdmin;
      console.log(isAdmin);
    });
    this.userService.loggedInEvent.subscribe((isLoggedIn) => {
      this.isLoggedIn = isLoggedIn;
      console.log(isLoggedIn);
    });
  }
}

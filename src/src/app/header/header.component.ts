import { Component, OnInit } from '@angular/core';
import { UserService } from '../shared/users.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  isAdmin: boolean;
  isLoggedIn: boolean;
  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.userService.adminEvent.subscribe((isAdmin) => {
      this.isAdmin = isAdmin;
    });
    this.userService.loggedInEvent.subscribe((isLoggedIn) => {
      this.isLoggedIn = isLoggedIn;
    });
  }
}

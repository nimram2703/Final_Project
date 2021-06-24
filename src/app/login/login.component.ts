import { Component, OnInit } from '@angular/core';
import { FormControl, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthResponse } from '../shared/AuthResonse.model';
import { LoginModel } from '../shared/login.model';
import { UserService } from '../shared/users.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  isLoggedIn: boolean = false;
  user: LoginModel = {
    emailId: '',
    password: '',
  };

  constructor(private router: Router, private userService: UserService) {}

  ngOnInit(): void {}

  onSubmit(form: NgForm) {

    console.log(form);
    this.user.emailId = form.value.email;
    this.user.password = form.value.password;
    this.userService.login(this.user).subscribe(
      (response: AuthResponse) => {
        console.log(response);
        localStorage.setItem('user', JSON.stringify(response));
        this.isLoggedIn = true;
        this.userService.adminEvent.emit(response.admin);
        this.userService.loggedInEvent.emit(this.isLoggedIn);
        if(response.admin){
          this.router.navigate(['add-flights'])
        }
        else{
          this.router.navigate(['search'])
        }
      },
      (error) => {
        console.log('login not successfull');
      }
    );
  }

  onLoad() {
    this.router.navigate(['registration']);
  }
}

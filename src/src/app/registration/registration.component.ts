import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../shared/user.model';
import { UserService } from '../shared/users.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent implements OnInit {
  RegistrationForm: FormGroup;
  user: User;
  isRegistered: boolean = false;
  showLoading: boolean;
  constructor(private router: Router, private userService: UserService) {
    this.RegistrationForm = new FormGroup({
      userName: new FormControl(null, [Validators.required]),
      password: new FormControl(null, [
        Validators.required,
        Validators.minLength(8),
      ]),
      confirmpassword: new FormControl(null, [Validators.required]),
      firstName: new FormControl(null, [Validators.required]),
      lastName: new FormControl(null, [Validators.required]),
      phoneNumber: new FormControl(null, [
        Validators.required,
        Validators.pattern('[789][0-9]{9}'),
      ]),
      emailId: new FormControl(null, [Validators.required, Validators.email]),
      dateOfBirth: new FormControl(null, [Validators.required]),
      gender: new FormControl(null, [Validators.required]),
    });
  }

  ngOnInit(): void {}
  onSubmit() {
    this.showLoading = true;
    this.user = this.RegistrationForm.value;
    this.userService.register(this.user).subscribe(
      (response: User) => {
        this.isRegistered = true;
        this.showLoading = false;
        console.log('user registred successfully');
        this.RegistrationForm.reset();
      },
      (error) => {
        this.isRegistered = false;
        this.showLoading = true;
        console.log(error);
      }
    );
  }

  onLoad() {
    this.router.navigate(['login']);
  }
}

import { HttpClient, HttpResponse } from '@angular/common/http';
import { EventEmitter, Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthResponse } from './AuthResonse.model';
import { LoginModel } from './login.model';
import { User } from './user.model';

@Injectable()
export class UserService implements OnInit {
  adminEvent = new EventEmitter<boolean>();
  loggedInEvent = new EventEmitter<boolean>();
  constructor(private http: HttpClient) {}
  ngOnInit() {}
  register(user: User): Observable<User> {
    return this.http.post<User>('http://localhost:9091/users/register', user);
  }
  login(loginModel: LoginModel): Observable<AuthResponse> {
    console.log('login');
    return this.http.post<AuthResponse>(
      'http://localhost:9091/users/login',
      loginModel
    );
  }
}

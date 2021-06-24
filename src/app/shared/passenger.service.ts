import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthResponse } from './AuthResonse.model';
import { Passenger } from './passenger.model';

@Injectable()
export class PassengerService {
  constructor(private http: HttpClient) {}
  addPassenger(
    passenger: Passenger,
    user: AuthResponse
  ): Observable<Passenger> {
    passenger.username = user.userName;
    return this.http.post<Passenger>(
      'http://localhost:9091/passengers/save',
      passenger
    );
  }
}

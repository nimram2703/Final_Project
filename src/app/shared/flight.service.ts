import { HttpClient } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthResponse } from './AuthResonse.model';
import { Flight } from './flight.model';
@Injectable()
export class FlightService {
  constructor(private http: HttpClient) {}
  bookFlight(flight: Flight, user: AuthResponse): Observable<Flight> {
    flight.username = user.userName;
    console.log(flight);
    return this.http.post<Flight>('http://localhost:9091/flights/add', flight);
  }
  getAllFlights(flight: Flight[]): Observable<Flight[]> {
    return this.http.post<Flight[]>(
      'http://localhost:9091/flights/searchToBook',
      flight
    );
  }
}

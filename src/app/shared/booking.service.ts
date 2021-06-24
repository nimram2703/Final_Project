import { HttpClient } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BookingInfo } from './bookingInfo.model';
import { BookingReport } from './bookingreport.model';

@Injectable({
  providedIn: 'root',
})
export class BookingService {
  constructor(private http: HttpClient) {}
  book(booking: BookingInfo): Observable<BookingReport> {
    return this.http.post<BookingReport>(
      'http://localhost:9091/bookings/book',
      booking
    );
  }
}

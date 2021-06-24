import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { PaymentComponent } from './payment/payment.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddFlightComponent } from './add-flights/add-flight.component';
import { HeaderComponent } from './header/header.component';
import { PassengersComponent } from './passengers/passengers.component';
import { BookinginfoComponent } from './bookinginfo/bookinginfo.component';
import { UserService } from './shared/users.service';
import { FlightService } from './shared/flight.service';
import { SearchflightsComponent } from './searchflights/searchflights.component';
import { PassengerService } from './shared/passenger.service';
import { AboutComponent } from './about/about.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegistrationComponent,
    PaymentComponent,
    PassengersComponent,
    AddFlightComponent,
    HeaderComponent,
    BookinginfoComponent,
    SearchflightsComponent,
    AboutComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [UserService, FlightService, PassengerService],
  bootstrap: [AppComponent],
})
export class AppModule {}

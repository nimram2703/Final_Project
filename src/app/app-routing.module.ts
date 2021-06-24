import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { AddFlightComponent } from './add-flights/add-flight.component';
import { BookinginfoComponent } from './bookinginfo/bookinginfo.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PassengersComponent } from './passengers/passengers.component';
import { PaymentComponent } from './payment/payment.component';
import { RegistrationComponent } from './registration/registration.component';
import { SearchflightsComponent } from './searchflights/searchflights.component';
import { BookingInfo } from './shared/bookingInfo.model';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'registration', component: RegistrationComponent },
  { path: 'passengers', component: PassengersComponent },
  { path: 'add-flights', component: AddFlightComponent },
  { path: 'register', component: RegistrationComponent },
  { path: 'search', component: SearchflightsComponent },
  { path: 'payment', component: PaymentComponent },
  { path: 'bookinginfo', component: BookinginfoComponent },
  { path: 'home', component: HomeComponent },
  { path: 'about', component: AboutComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
<<<<<<< HEAD
import { NavComponent } from './nav/nav.component';
import { CityComponent } from './city/city.component';
=======
import { BurbankComponent } from './burbank/burbank.component';
import { ChicagoComponent } from './chicago/chicago.component';
import { DallasComponent } from './dallas/dallas.component';
import { DcComponent } from './dc/dc.component';
import { SanjoseComponent } from './sanjose/sanjose.component';
import { SeattleComponent } from './seattle/seattle.component';
import { HttpClient } from '@angular/common/http';
import { HttpService } from './http.service';
>>>>>>> e488f649df7259e8e5fcd02c018af6411dce8617

@NgModule({
  declarations: [
    AppComponent,
<<<<<<< HEAD
    NavComponent,
    CityComponent
=======
    BurbankComponent,
    ChicagoComponent,
    DallasComponent,
    DcComponent,
    SanjoseComponent,
    SeattleComponent
>>>>>>> e488f649df7259e8e5fcd02c018af6411dce8617
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClient,
  ],
  providers: [HttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }

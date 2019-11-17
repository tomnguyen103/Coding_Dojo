import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Weather } from '../weather';

@Component({
  selector: 'app-burbank',
  templateUrl: './burbank.component.html',
  styleUrls: ['./burbank.component.css']
})
export class BurbankComponent implements OnInit {
  public weather: Weather;

  constructor(private _httpService: HttpService) { }

  ngOnInit() {
    this._httpService.getWeather('burbank')
    .subscribe(weather => this.weather = weather);
  }

}

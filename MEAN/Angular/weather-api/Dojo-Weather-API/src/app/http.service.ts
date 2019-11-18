import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
<<<<<<< HEAD
=======
import { Observable } from 'rxjs';
import { Weather } from './weather';
import { map } from 'rxjs/operators';
>>>>>>> e488f649df7259e8e5fcd02c018af6411dce8617

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  api_key: String;

<<<<<<< HEAD
  constructor(private _http: HttpClient) { }

  getWeather(callback, city: City){

=======
  private readonly base = "/api/weather/";

  constructor(private _http: HttpClient) { }
  
  getWeather(city: string): Observable<Weather> {
    return this._http.get(`http://api.openweathermap.org/data/2.5/weather?q=${city}&APPID=4c36f92139746c0d831dfaf91a78dc2c&units=Imperial`).pipe(map(data => {
      const weather = data as any;
      return new Weather(weather.main.humidity, weather.main.temp, weather.main.temp_max, weather.main.temp_min, weather.wind.speed, weather.weather[0].description)
    }));
>>>>>>> e488f649df7259e8e5fcd02c018af6411dce8617
  }
}

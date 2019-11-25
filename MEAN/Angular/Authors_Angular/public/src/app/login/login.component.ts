import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginUser = {
    email: '',
    password: '',
  }

  constructor(
    private _httpService: HttpService,
    private _router: Router
    ) { }

  ngOnInit() {
  }

  handleLogin(){
    this._httpService.loginUser(this.loginUser)
    .subscribe((data: any)=>{
      if(data.status == "success"){
        this._router.navigate(['/'])
      }else{
        
      }
    })
  }
}

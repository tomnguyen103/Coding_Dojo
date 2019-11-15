import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-author',
  templateUrl: './new-author.component.html',
  styleUrls: ['./new-author.component.css']
})
export class NewAuthorComponent implements OnInit {
  errors = [];

  newAuthor = {
    name: '',
    age: ''
  }

  constructor(
    private _httpService: HttpService,
    private _router: Router,
  ) { }

  ngOnInit() {
  }

  handleSubmit(){
    this._httpService.createAuthor(this.newAuthor)
    .subscribe((data:any)=> {
      if(data.hasOwnProperty('errors')){
        for(let key in data.errors){
          this.errors.push(data.errors[key].message);
        }
      }else{
        this._router.navigate(['/'])
      }
    })
  }

}

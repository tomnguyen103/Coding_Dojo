import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-pet',
  templateUrl: './new-pet.component.html',
  styleUrls: ['./new-pet.component.css']
})
export class NewPetComponent implements OnInit {

  errors = [];

  newPet = {
    name: '',
    type: '',
    description: '',
    skill1: '',
    skill2: '',
    skill3: '',
  }

  constructor(
    private _httpService: HttpService,
    private _router: Router
    ) { }

  ngOnInit() {
  }

  handleSubmit(){
    this._httpService.createPet(this.newPet)
    .subscribe((data:any)=> {
      this.errors= [];
      if(data.hasOwnProperty('errors')){
        for(let key in data.errors){
          this.errors.push(data.errors[key].message);
        }
      }else{
        this._router.navigate(['/'])
      }
    })
    this.newPet = {
      name: '',
      type: '',
      description: '',
      skill1: '',
      skill2: '',
      skill3: '',
    }
  }

}

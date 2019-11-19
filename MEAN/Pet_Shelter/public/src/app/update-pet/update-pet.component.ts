import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { ActivatedRoute, Router, Params } from '@angular/router';

@Component({
  selector: 'app-update-pet',
  templateUrl: './update-pet.component.html',
  styleUrls: ['./update-pet.component.css']
})
export class UpdatePetComponent implements OnInit {
  pet = null;

  errors = [];

  constructor(
    private _httpService: HttpService,
    private _route: ActivatedRoute,
    private _router: Router
  ) { }

  ngOnInit() {
    this._route.params
    .subscribe((params: Params)=>{
      this._httpService.getPetById(params.id)
      .subscribe((data:any)=> this.pet = data.pet)
    })
  }

  handleSubmit(){
    this.errors = [];
    this._httpService.updatePet(this.pet._id,{
      name: this.pet.name,
      type: this.pet.type,
      description: this.pet.description,
      skill1: this.pet.skill1,
      skill2: this.pet.skill2,
      skill3: this.pet.skill3,
    })
    .subscribe((data:any)=>{
      if(data.hasOwnProperty('errors')){
        for(let key in data.errors){
          this.errors.push(data.errors[key].message);
        }
      }else{
        this._router.navigate(['/pets/'+ this.pet._id])
      }
    })
  }

}

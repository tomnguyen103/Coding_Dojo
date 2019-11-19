import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Router, ActivatedRoute, Params } from '@angular/router';


@Component({
  selector: 'app-single-pet',
  templateUrl: './single-pet.component.html',
  styleUrls: ['./single-pet.component.css']
})
export class SinglePetComponent implements OnInit {
  pet = null;

  constructor(
    private _httpService: HttpService,
    private _router: Router,
    private _route: ActivatedRoute
  ) { }

  ngOnInit() {
    this._route.params
    .subscribe((params: Params) => {
      this._httpService.getPetById(params.id)
      .subscribe((data:any)=> this.pet=data.pet)
    })
  }

  adoptPet(){
    this._route.params
    .subscribe((params: Params)=>{
      this._httpService.deletePet(params.id)
      .subscribe(()=> this._router.navigate(['/pets']))
    })
  }



}

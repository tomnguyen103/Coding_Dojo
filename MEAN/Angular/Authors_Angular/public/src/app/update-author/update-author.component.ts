import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { ActivatedRoute, Params, Router } from '@angular/router';

@Component({
  selector: 'app-update-author',
  templateUrl: './update-author.component.html',
  styleUrls: ['./update-author.component.css']
})
export class UpdateAuthorComponent implements OnInit {
  author = null;

  errors = [];

  constructor(
    private _httpService: HttpService,
    private _route: ActivatedRoute,
    private _router: Router
  ) { }

  ngOnInit() {
    this._route.params
    .subscribe((params: Params)=>{
      this._httpService.getAuthorById(params.id)
      .subscribe((data:any)=> this.author = data.author)
    })
  }

  handleSubmit(){
    this.errors = [];
    this._httpService.updateAuthor(this.author._id, {
      name: this.author.name,
      age: this.author.age
    })
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

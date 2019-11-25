import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-all-authors',
  templateUrl: './all-authors.component.html',
  styleUrls: ['./all-authors.component.css']
})
export class AllAuthorsComponent implements OnInit {
  authors = [];

  constructor(
    private _httpService: HttpService,
    private _router: Router
  ) { }

  ngOnInit() {
    this._httpService.getCurrentUser()
    .subscribe((data: any)=> {
      if(data.user){
        //cool there's a user
      } else{
        this._router.navigate(['/login'])
      }
    })

    this._httpService.getAuthors()
    .subscribe((data:any)=> this.authors = data.authors)
  }

  goToEditPage(id){
    this._router.navigate(['/edit/'+id])
  }

  deleteAuthor(id){
    this._httpService.deleteAuthor(id)
    .subscribe( ()=>{
      this.authors = this.authors.filter(author => author._id != id)
    })
  }

  handleLogout(){
    this._httpService.logoutUser()
    .subscribe(()=> this._router.navigate(['/login']))
  }
}

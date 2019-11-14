import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-task',
  templateUrl: './new-task.component.html',
  styleUrls: ['./new-task.component.css']
})
export class NewTaskComponent implements OnInit {
  tasks = [];

  newTask= {
    title: '',
    description: '',
    completed: false
  };

  constructor(
    private _httpService: HttpService, 
    private _router: Router
    ) { }

  ngOnInit() {
  }

  onSubmit(){
    this._httpService.addTask(this.newTask)
    .subscribe(() => this._router.navigate(['/tasks']))

    this.newTask = { title: '', description: '', completed: false}
  }

}

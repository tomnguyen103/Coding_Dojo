import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'public';
  tasks = [];
  selectedTask = null;

  constructor(private _httpClient: HttpClient){
  }

  
  ngOnInit(){
    this.getTasks();
  }
  getTasks(){
    this._httpClient.get('/api/tasks')
    .subscribe((data: any) => this.tasks = data.tasks)
  }

  selectTask(task){
    this.selectedTask = task;
  }

}

import { Component, OnInit  } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'public';
  tasks = [];
  newTask: any;
  editTask = [];
  selectedTask = null;
  self = this;

  constructor(private _httpClient: HttpClient){
  }
  
  ngOnInit(){
    this.newTask = { title: "", description: ""};
  }

  onSubmit(){
    this._httpClient.post('/api/tasks',this.newTask)
    .subscribe((data:any) => this.tasks = data.tasks);

    this.newTask = { title: "", description: ""}
  }

  getTasks(){
    this._httpClient.get('/api/tasks')
    .subscribe((data: any) => this.tasks = data.tasks)
  }

  selectTask(task){
    this.selectedTask = task;
  }
  getTask(task_id){
    this._httpClient.get(task_id)
    .subscribe((data:any) => this.tasks = data['title']);
  }
  // updateTask(task){
  //   this._httpClient.put('/api/tasks/'+task._id,task)
  //   .subscribe((data:any)=> this.tasks = data.tasks)

  // }
}

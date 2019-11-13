import { Component, OnInit  } from '@angular/core';
import { HttpService } from './http.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'public';
  tasks = [];

  newTask= {
    title: '',
    description: '',
    completed: false
  };

  editTask = null;
  selectedTask = null;
  deleteTask = null;
  self = this;

  constructor(private _httpService: HttpService){
    
  }
  
  ngOnInit(){
    this.getTasks();
  }

  onSubmit(){
    this._httpService.addTask(this.newTask)
    .subscribe((data:any) => this.tasks.push(data.task))

    this.newTask = { title: '', description: '', completed: false}
  }

  getTasks(){
    this._httpService.getTasks()
    .subscribe((data: any) => this.tasks = data.tasks)
  }
  selectTask(task){
    this.selectedTask = task;
  }
  
  getTask(task_id){
    this._httpService.getTask(task_id)
    .subscribe((data:any) => this.tasks = data['title']);
  }
  taskForm(task){
    this.editTask = task;
  }

  updateTask(){
    this._httpService.updateTask(this.editTask)
    .subscribe((data:any)=> {this.editTask = null})
  }

  selectDeleteTask(task){
    // this.deleteTask = task;
    this._httpService.deleteTask(task)
    .subscribe((() => this.getTasks()))
  }
}

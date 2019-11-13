import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private _http: HttpClient) { 
    this.getTasks();
  }
  getTasks(){
    return this._http.get('/api/tasks');
  }
  getTask(task_id){
    return this._http.get('/api/tasks/' + task_id)
  }
  addTask(newTask){
    return this._http.post('/api/tasks', newTask);
  }
  // editTask(task){
  //   return this._http.put('/api/tasks/' + task._id, task)
  // }
  deleteTask(task_id){
    return this._http.delete('/api/tasks/' + task_id)
  }
}

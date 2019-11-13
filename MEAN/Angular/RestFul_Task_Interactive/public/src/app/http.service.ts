import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private _httpClient: HttpClient) { 
  }
  getTasks(){
    return this._httpClient.get('/api/tasks');
  }

  addTask(newTask){
    return this._httpClient.post('/api/tasks', newTask);
  }

  getTask(task_id){
    return this._httpClient.get(`/api/tasks/${task_id}`)
  }
  updateTask(task){
    return this._httpClient.put(`/api/tasks/${task._id}`, task)
  }

  deleteTask(task){
    return this._httpClient.delete(`/api/tasks/${task._id}`)
  }
}

import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-all-tasks',
  templateUrl: './all-tasks.component.html',
  styleUrls: ['./all-tasks.component.css']
})
export class AllTasksComponent implements OnInit {
  tasks = [];

  constructor(
    private _httpService: HttpService,
    private _router: Router
    ) { }

  ngOnInit() {
    this._httpService.getTasks()
    .subscribe((data:any) => this.tasks = data.tasks);
  }

  selectTask(task){
    this._router.navigate(['/tasks/' + task._id]);
  }

}

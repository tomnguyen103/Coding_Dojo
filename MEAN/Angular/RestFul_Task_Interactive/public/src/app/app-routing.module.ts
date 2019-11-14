import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SingleTaskComponent } from './single-task/single-task.component';
import { NewTaskComponent } from './new-task/new-task.component';
import { AllTasksComponent } from './all-tasks/all-tasks.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';


const routes: Routes = [
  {
    path: 'tasks/new',
    component: NewTaskComponent
  },
  {
    path: 'tasks/:id',
    component: SingleTaskComponent
  },
  {
    path: 'tasks',
    component: AllTasksComponent
  },
  {
    path: '',
    redirectTo: '/tasks',
    pathMatch: 'full'
  },
  {
    path: '**',
    component: PageNotFoundComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NewAuthorComponent } from './new-author/new-author.component';
import { UpdateAuthorComponent } from './update-author/update-author.component';
import { AllAuthorsComponent } from './all-authors/all-authors.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
  {
    path: 'new',
    component: NewAuthorComponent
  },
  {
    path: 'edit/:id',
    component: UpdateAuthorComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: '',
    component: AllAuthorsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

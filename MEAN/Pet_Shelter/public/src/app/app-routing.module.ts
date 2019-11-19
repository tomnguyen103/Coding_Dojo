import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AllPetsComponent } from './all-pets/all-pets.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { NewPetComponent } from './new-pet/new-pet.component';
import { UpdatePetComponent } from './update-pet/update-pet.component';
import { SinglePetComponent } from './single-pet/single-pet.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: "/pets",
    pathMatch: 'full'
  },
  {
    path: 'pets',
    component: AllPetsComponent
  },
  {
    path: 'pets/new',
    component: NewPetComponent
  },
  {
    path: 'pets/:id/edit',
    component: UpdatePetComponent
  },
  {
    path: 'pets/:id',
    component: SinglePetComponent
  },
  {
    path: '**',
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

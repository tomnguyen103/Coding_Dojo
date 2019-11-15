import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NavComponent } from './nav/nav.component';
import { HomeComponent } from './home/home.component';
import { ProductComponent } from './product/product.component';
import { ListComponent } from './product/list/list.component';
import { CreateComponent } from './product/create/create.component';
import { EditComponent } from './product/edit/edit.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';


const routes: Routes = [
  {
    path: '',
    component: NavComponent,
    children: [
      {
        path: '',
        component: HomeComponent
      },
      {
        path: 'products',
        pathMatch: 'full',
        component: ProductComponent,
        children:[
          {
            path: '',
            component: ListComponent,
          },
          {
            path: 'edit/:id',
            component: EditComponent,
          }
        ]
      },
      {
        path: 'products/new',
        component: CreateComponent,
      },
    ]
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

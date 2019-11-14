import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { HttpService } from './http.service';
import { FormsModule } from '@angular/forms';
import { TaskComponent } from './task/task.component';
import { SingleTaskComponent } from './single-task/single-task.component';
import { NewTaskComponent } from './new-task/new-task.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AllTasksComponent } from './all-tasks/all-tasks.component';


@NgModule({
  declarations: [
    AppComponent,
    TaskComponent,
    SingleTaskComponent,
    NewTaskComponent,
    PageNotFoundComponent,
    AllTasksComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [HttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TasksComponent } from './tasks/tasks.component';
import { TasksAddComponent } from './tasks/tasks-add/tasks-add.component';
import { TasksListComponent } from './tasks/tasks-list/tasks-list.component';
import { TasksService } from './tasks/task.service';
import { Http, ConnectionBackend, HttpModule } from '@angular/http';

@NgModule({
  declarations: [
    AppComponent,
    TasksComponent,
    TasksAddComponent,
    TasksListComponent
  ],
  imports: [
    BrowserModule,
    HttpModule
  ],
  providers: [
    TasksService
   ],
  bootstrap: [AppComponent]
})
export class AppModule { }

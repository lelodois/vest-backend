import { Component, OnInit } from '@angular/core';
import { TasksService } from '../task.service';
import { Task } from '../task.model';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-tasks-list',
  templateUrl: './tasks-list.component.html',
  styleUrls: ['./tasks-list.component.css']
})
export class TasksListComponent implements OnInit {

  tasks;
  
  constructor(private service : TasksService){
  }

  ngOnInit() {
    return this.service.getTasks()
      .subscribe( 
        (tasks : Observable<Task>) => {
          this.tasks = tasks
        },
        (error) => console.log('Erro desconhecido', error)
      );
}

  getDueDateLabel(task:Task){
    return task.completed ? 'label-success' : 'label-primary';
  }


  onTaskChanged(event, task:Task){
    this.service.saveTask(task, event.target.checked);
  }

}

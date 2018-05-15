import { Component, OnInit } from '@angular/core';
import { TasksService } from '../task.service';
import { Task } from '../task.model';

@Component({
  selector: 'app-tasks-list',
  templateUrl: './tasks-list.component.html',
  styleUrls: ['./tasks-list.component.css']
})
export class TasksListComponent implements OnInit {

  tasks : Task[] = [];
  
  constructor(private service : TasksService){
  }

  ngOnInit() {
    this.service.getTasks()
      .subscribe( 
        (tasks : any[]) => {
          this.tasks = tasks
        },
        (error) => console.log('Erro desconhecido', error)
      );

    this.service.taskAddedEvent
      .subscribe(
        (task: Task) => this.tasks.push(task)
    )
}

  getDueDateLabel(task:Task){
    return task.completed ? 'Finalizada' : 'Em andamento';
  }


  onTaskChanged(event, task:Task){
    this.service.saveTask(task, event.target.checked).subscribe();
  }

}

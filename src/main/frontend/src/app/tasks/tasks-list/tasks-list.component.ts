import { Component, OnInit } from '@angular/core';
import { TasksService } from '../task.service';
import { Task } from '../task.model';

@Component({
  selector: 'app-tasks-list',
  templateUrl: './tasks-list.component.html',
  styleUrls: ['./tasks-list.component.css']
})
export class TasksListComponent implements OnInit {

  tasks: Task[] = [];

  constructor(private service: TasksService) {
  }

  ngOnInit() {
    this.getTasks();

    this.service.taskAddedEvent.subscribe(
      (task: Task) => {
        this.getTasks()
      }
    );
  }

  getTasks(){
    this.service.getTasks()
      .subscribe(
        (tasks: any[]) => {
          this.tasks = tasks;
        },
        (error) => console.log('Erro desconhecido', error)
      )
  }


  getTaskLabel(task: Task) {
    return task.concordancia ? 'Assinou embaixo' : 'Não concordou';
  }

  onTaskEdit(task: Task) {
    this.service.taskEditEvent.emit(task);
  }
  
  onTaskChanged(event, task: Task) {
    task.concordancia = event.target.checked;
    this.service.saveTask(task).subscribe();
  }
}

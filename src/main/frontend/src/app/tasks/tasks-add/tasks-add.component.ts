import { Component, OnInit } from '@angular/core';
import { TasksService } from '../task.service';
import { Task } from '../task.model';

@Component({
  selector: 'app-tasks-add',
  templateUrl: './tasks-add.component.html',
  styleUrls: [ './tasks-add.component.css']
})
export class TasksAddComponent implements OnInit {

  addTaskValue : string = null;

  constructor(private service : TasksService){
  }

  ngOnInit() {
  }

  onTaskAdd(event){
    let task = new Task(undefined, 
                        event.target.value, 
                        false, 
                        new Date().toDateString());
    this.service.saveTask(task, false)
      .subscribe((newTask: Task) => {
        this.addTaskValue = ' ';
        this.service.taskAddedEvent.emit(newTask);
      }
    );
  }

}

import { Component, OnInit } from '@angular/core';
import { TasksService } from '../task.service';
import { Task } from '../task.model';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-tasks-add',
  templateUrl: './tasks-add.component.html',
  styleUrls: [ './tasks-add.component.css']
})
export class TasksAddComponent implements OnInit {

  task: Task = new Task();
  taskForm : FormGroup;

  constructor(private service: TasksService) {
  }

  ngOnInit() {
    this.taskForm = new FormGroup({
      name: new FormControl('', Validators.required),
      definitionOfDone: new FormControl('', Validators.required),
      participantes: new FormControl('', Validators.required)
    });
  }

  save(){
    this.service.saveTask(this.task)
                .subscribe(
                  (newTask: Task) => {
                  this.service.taskAddedEvent.emit(newTask);
                }
          );
  }
}

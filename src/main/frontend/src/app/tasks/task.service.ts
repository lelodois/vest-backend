import { Task } from "./task.model";
import { Http, Response } from '@angular/http';
import { Injectable, EventEmitter } from "@angular/core";
import "rxjs/add/operator/map";
import { HttpClient, HttpRequest } from "selenium-webdriver/http";

@Injectable()
export class TasksService{

    taskAddedEvent = new EventEmitter<Task>();

    constructor(private http:Http){
    }

    getTasks() {
        let tasks = this.http.get("/api/tasks/");
        return tasks.map(response => response.json())
    }
    
    saveTask(task : Task, completed : boolean){
        task.completed = completed;
        let post = this.http.post('/api/tasks/save', task);
        return post.map(response => response.json());
    }
}
import { Task } from "./task.model";
import { Http, Response } from '@angular/http';
import { Injectable } from "@angular/core";
import "rxjs/add/operator/map";
import { HttpClient, HttpRequest } from "selenium-webdriver/http";

@Injectable()
export class TasksService{

    constructor(private http:Http){
    }

    getTasks() {
        let tasks = this.http.get("/api/tasks");
        return tasks.map(response => response.json())
    }
    
    saveTask(task : Task, completed : boolean){
        task.completed = completed;
        console.log("Task changed success");
    }
}
package br.com.lelo.backend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.lelo.backend.model.Task;
import br.com.lelo.backend.repository.TaskRepository;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/api/tasks/")
    public Iterable<Task> list() throws Exception {
        return repository.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/api/tasks/save")
    public Task novo(@Valid @RequestBody Task task) throws Exception {
        return repository.save(task);
    }

}

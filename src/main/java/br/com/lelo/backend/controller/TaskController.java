package br.com.lelo.backend.controller;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lelo.backend.model.Task;

@RestController
@RequestMapping(value = "/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

	@Autowired
	private TaskService service;

	@GetMapping("/")
	public Iterable<Task> list() throws Exception {
		return service.findAll();
	}

	@PostMapping(value = "/save")
	public Task save(@Valid @RequestBody Task task) throws Exception {
		task.setName(StringUtils.capitalize(task.getName().toLowerCase()));

		if (task.getId() != null) {
			return service.save(task, service.getOne(task.getId()));
		} else {
			Task exists = service.getOne(task.getName());
			return service.save(task, exists);
		}
	}
}

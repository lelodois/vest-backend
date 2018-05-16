package br.com.lelo.backend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lelo.backend.model.Task;
import br.com.lelo.backend.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	public TaskRepository repository;

	public Task save(Task taskNew, Task taskWork) {
		if (taskWork != null) {
			BeanUtils.copyProperties(taskNew, taskWork, new String[] { "id" });
			return repository.save(taskWork);
		}
		return repository.save(taskNew);
	}

	public Iterable<Task> findAll() {
		return repository.findAll();
	}

	public Task getOne(Long id) {
		return repository.getOne(id);
	}

	public Task getOne(String name) {
		return repository.findByName(name);
	}

}
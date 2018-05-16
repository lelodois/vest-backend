package br.com.lelo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lelo.backend.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	Task findByName(String name);
}

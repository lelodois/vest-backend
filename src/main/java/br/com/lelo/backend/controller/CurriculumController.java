package br.com.lelo.backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lelo.backend.model.Curriculum;
import br.com.lelo.backend.repository.CurriculumRepository;

@RestController
@RequestMapping("api-curriculum")
public class CurriculumController {

	@Autowired
	private CurriculumRepository repository;

	@PostMapping(value = "novo")
	@CrossOrigin(origins = "*")
	public Curriculum novo(@Valid @RequestBody Curriculum curriculum) throws Exception {
		return repository.save(curriculum);
	}

	@GetMapping(value = "/")
	@CrossOrigin(origins = "*")
	public List<Curriculum> getAll() throws Exception {
		return repository.findAll();
	}

}

package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	private final StudentRepository repo;

	public StudentController(StudentRepository repo) {
		super();
		this.repo = repo;
	}

	@GetMapping("/{name}")
	public String home(@PathVariable("name")String name) {
		return "Hello "+name;
	}
	
	@PostMapping("addStudent")
	@ResponseStatus(HttpStatus.CREATED)
	public Student add(@RequestBody Student student) {
		return repo.save(student);
	}
	
	@GetMapping("getAllStudent")
	public List<Student> getAll(){
		return repo.findAll();
		}
	
	@GetMapping("getById/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Student> getById(@PathVariable("id")Integer id) {
		return repo.findById(id);
	}
	@DeleteMapping("delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String delete(@PathVariable("id") Integer id) {
		repo.deleteById(id);
		return "deleted";
	}

}

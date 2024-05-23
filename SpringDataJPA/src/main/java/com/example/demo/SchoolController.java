package com.example.demo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {
	
	private SchoolRepository schoolRepo;
	
	public SchoolController(SchoolRepository schoolRepo) {
		super();
		this.schoolRepo = schoolRepo;
	}

	@PostMapping("/addSchool")
	@ResponseStatus(HttpStatus.CREATED)
	public School add(@RequestBody School school) {
		return schoolRepo.save(school);
	}
	
	@GetMapping("/getAllSchool")
	public List<School> getAllSchool(){
		return schoolRepo.findAll();	}

}

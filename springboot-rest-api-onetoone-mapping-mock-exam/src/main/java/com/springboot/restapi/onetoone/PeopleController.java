package com.springboot.restapi.onetoone;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class PeopleController {
	
	private PeopleRepository pRepository;
	
	@GetMapping
	public List<People>  getAllPeople(){
		return pRepository.findAll();
	}
	
	@PostMapping
	
	public People creatPeople() {
		return null;
	}

}

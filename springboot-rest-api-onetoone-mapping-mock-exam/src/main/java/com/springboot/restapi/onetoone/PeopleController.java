package com.springboot.restapi.onetoone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/peoples")
public class PeopleController {
	
	 @Autowired
	private PeopleRepository pRepository;
	
	@GetMapping
	public List<People>  getAllPeople(){
		return pRepository.findAll();
	}
	
	 @PostMapping
	    public People create(@RequestBody People people) {
	        return pRepository.save(people);
	    }
	 
	 @GetMapping("/{id}")
	    public People getPeopleById(@PathVariable Long id) {
	        return pRepository.findById(id).orElseThrow();
	    }

	    @PutMapping("/{id}")
	    public People updatePeople(@PathVariable Long id, @RequestBody People peopleDetails) {
	        People people = pRepository.findById(id).orElseThrow();
	        
	        people.setFirstname(peopleDetails.getFirstname());
	        people.setLastname(peopleDetails.getLastname());
	        
	        return pRepository.save(people);
	    }
	    
	    @DeleteMapping("/{id}")
	    public void deletePeople(@PathVariable Long id) {
	        People people = pRepository.findById(id).orElseThrow();
	        pRepository.delete(people);
	    }
	    
	    @GetMapping("/paginated")
	    public Page<People> getPeoplePaginated(
	        @PageableDefault(size = 10, sort = "firstname") Pageable pageable) {
	        return pRepository.findAll(pageable);
	    }

	    @GetMapping("/sorted")
	    public List<People> getPeopleSorted(
	        @RequestParam(defaultValue = "firstname") String sortBy,
	        @RequestParam(defaultValue = "asc") String direction) {
	        
	        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
	        return pRepository.findAll(sort);
	    }
}

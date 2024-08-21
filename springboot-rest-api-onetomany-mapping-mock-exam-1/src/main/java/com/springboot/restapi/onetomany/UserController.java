package com.springboot.restapi.onetomany;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserRepository uRepository;
	
	
	@GetMapping
	public List<User> getAllUsers(){
		return uRepository.findAll();
	}
	
	@PostMapping 
	public User creatUser(@RequestBody User user) {
		return uRepository.save(user);
	}
	
	@GetMapping("/{id}")
	
	public User getUserById(@PathVariable Long id) {
		return uRepository.findById(id).orElse(null);
	}
	
	@PutMapping("/{id}")
	public User updateUserById(@PathVariable Long id,@RequestBody User user) {
		return uRepository.save(user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable Long id) {
		 uRepository.deleteById(id);
	}
	
	@GetMapping("/page")
    public Page<User> getUsersPaginated(@RequestParam(defaultValue = "0") int page, 
                                        @RequestParam(defaultValue = "10") int size) {
        return uRepository.findAll(PageRequest.of(page, size));
    }
	
	 @GetMapping("/sorted")
	    public List<User> getUsersSorted(
	            @RequestParam(defaultValue = "id") String sortBy,
	            @RequestParam(defaultValue = "asc") String sortDirection) {
	        
	        Sort.Direction direction = sortDirection.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
	        return uRepository.findAll(Sort.by(direction, sortBy));
	    }
}
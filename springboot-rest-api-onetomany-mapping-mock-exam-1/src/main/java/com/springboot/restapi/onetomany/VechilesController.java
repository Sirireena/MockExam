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
@RequestMapping("/vehicles")
public class VechilesController {

    @Autowired
    private VechilesRepository vehicleRepository;

    @GetMapping
    public List<Vechiles> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Vechiles getVehicleById(@PathVariable Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Vechiles createVehicle(@RequestBody Vechiles vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @PutMapping("/{id}")
    public Vechiles updateVehicle(@PathVariable Long id, @RequestBody Vechiles vehicle) {
        vehicle.setId(id);
        return vehicleRepository.save(vehicle);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleRepository.deleteById(id);
    }
    
    @GetMapping("/paginated")
    public Page<Vechiles> getVehiclesPaginated(@RequestParam(defaultValue = "0") int page, 
                                              @RequestParam(defaultValue = "10") int size) {
        return vehicleRepository.findAll(PageRequest.of(page, size));
    }
    
    @GetMapping("/sorted")
    public List<Vechiles> getVehiclesSorted(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection) {
        
        Sort.Direction direction = sortDirection.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        return vehicleRepository.findAll(Sort.by(direction, sortBy));
    }
}


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
@RequestMapping("/api/banks")
public class BankController {

    @Autowired
    private BankRepository bankRepository;


    @PostMapping
    public Bank create(@RequestBody Bank bank) {
        return bankRepository.save(bank);
    }


    @GetMapping("/{id}")
    public Bank read(@PathVariable Long id) {
        return bankRepository.findById(id).orElseThrow();
    }


    @PutMapping("/{id}")
    public Bank update(@PathVariable Long id, @RequestBody Bank bankDetails) {
        Bank bank = bankRepository.findById(id).orElseThrow();
        bank.setBankname(bankDetails.getBankname());
        bank.setPhoneno(bankDetails.getPhoneno());
        return bankRepository.save(bank);
    }


    @DeleteMapping("/{id}")
    public void deleteBank(@PathVariable Long id) {
        Bank bank = bankRepository.findById(id).orElseThrow();
        bankRepository.delete(bank);
    }
    
    @GetMapping("/paginated")
    public Page<Bank> getBanksPaginated(
        @PageableDefault(size = 10, sort = "bankname") Pageable pageable) {
        return bankRepository.findAll(pageable);
    }

    @GetMapping("/sorted")
    public List<Bank> getBanksSorted(
        @RequestParam(defaultValue = "bankname") String sortBy,
        @RequestParam(defaultValue = "asc") String direction) {
        
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        return bankRepository.findAll(sort);
    }
}


package com.example.demo.controller;



import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping("/{id}")
    public Customer getTransfer(@PathVariable Long id){
        return customerRepository.getById(id);
    }


    @GetMapping("/all")
    public List<Customer> getAllTransfers(){
        return customerRepository.findAll();
    }


    @PostMapping("/add")
    public void add(@RequestBody Customer transfer){
        customerRepository.save(transfer);
    }


    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Long id){
        customerRepository.deleteById(id);

    }

}


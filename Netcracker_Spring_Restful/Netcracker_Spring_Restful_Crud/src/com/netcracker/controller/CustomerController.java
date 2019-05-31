package com.netcracker.controller;

import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Customer;
import com.netcracker.repository.CustomerRepository;
import com.netcracker.service.api.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/buyer")
    public List<Customer> getAllCustomers() {
        return  customerService.getCustomers();
    }

    @GetMapping("/buyer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value="id") Integer id) throws ResourceNotFoundException {
        return customerService.getCustomerById(id);
    }

    @PostMapping("/buyer")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @DeleteMapping("/buyer/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return customerService.deleteCustomerById(id);
    }

    @DeleteMapping("/buyer")
    public ResponseEntity<String> deleteAllCustomers() {
        return customerService.deleteAllCustomers();
    }
}

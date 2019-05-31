package com.netcracker.service.impl;

import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Customer;
import com.netcracker.repository.CustomerRepository;
import com.netcracker.service.api.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServlet;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public ResponseEntity<Customer> getCustomerById(Integer id) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact not found! id=" + id));
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    @Override
    public ResponseEntity<Customer> addCustomer(Customer customer) {
        return ResponseEntity.status(HttpStatus.OK).body(customerRepository.save(customer));
    }

    @Override
    public ResponseEntity<String> deleteCustomerById(Integer id) throws ResourceNotFoundException {
        Customer customer = getCustomerById(id).getBody();
        customerRepository.delete(customer);
        return ResponseEntity.status(HttpStatus.OK).body("Delete with id: " + id);
    }

    @Override
    public ResponseEntity<String> deleteAllCustomers() {
        customerRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("Delete all customers");
    }
}
package com.netcracker.service.api;

import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    ResponseEntity<Customer> getCustomerById(Integer id) throws ResourceNotFoundException;
    ResponseEntity<Customer> addCustomer(Customer customer);
    ResponseEntity<String> deleteCustomerById(Integer id) throws ResourceNotFoundException;
    ResponseEntity<String> deleteAllCustomers();
}

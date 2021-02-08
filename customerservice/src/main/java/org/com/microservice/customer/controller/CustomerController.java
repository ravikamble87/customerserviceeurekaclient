package org.com.microservice.customer.controller;

import org.com.microservice.customer.model.Customer;
import org.com.microservice.customer.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api/customers",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping(value = "/")
  public ResponseEntity<Collection<Customer>> getAllCustomers() {
    List<Customer> listCustomers = customerService.fetchAllCustomers();
    return new ResponseEntity<>(listCustomers, HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Customer> getCustomer(@PathVariable("id") String customerId) {
    Customer customer = customerService.fetchCustomerById(customerId);
    return new ResponseEntity<>(customer, HttpStatus.OK);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long customerId,
                                               @RequestBody final Customer customer) {
  
    Customer savedCustomer = customerService.saveCustomerInfo(customer);
    return new ResponseEntity<>(savedCustomer, HttpStatus.OK);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> deleteCustomer(@PathVariable(name = "id") String customerId) {
    
    customerService.deleteCustomer(customerId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping(value = "/")
  public ResponseEntity<Customer> createCustomer(@RequestBody final Customer customer) {
    
    Customer savedCustomer = customerService.saveCustomerInfo(customer);
    return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
  }
}
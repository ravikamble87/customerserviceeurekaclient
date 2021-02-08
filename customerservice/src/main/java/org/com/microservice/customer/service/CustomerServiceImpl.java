package org.com.microservice.customer.service;

import org.com.microservice.customer.model.Customer;
import org.com.microservice.customer.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public List<Customer> fetchAllCustomers() {
    return customerRepository.getAllCustomers();
  }

  @Override
  public Customer fetchCustomerById(String id) {
    return customerRepository.findById(id).get();
  }

  @Override
  public Customer saveCustomerInfo(Customer customer) {
    return customerRepository.save(customer);
  }

  @Override
  public void deleteCustomer(String id) {
    customerRepository.deleteById(id);
  }

}

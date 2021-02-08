package org.com.microservice.customer.service;

import org.com.microservice.customer.model.Customer;

import java.util.List;

public interface CustomerService {

  List<Customer> fetchAllCustomers();

  Customer fetchCustomerById(String id);

  Customer saveCustomerInfo(Customer account);

  void deleteCustomer(String id);
}

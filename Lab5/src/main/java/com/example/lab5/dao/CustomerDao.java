package com.example.lab5.dao;


import com.example.lab5.model.Customer;
import jakarta.ejb.Local;

import java.util.List;


@Local
public interface CustomerDao {

    Customer findCustomerById(Long id);

    List<Customer> allCustomers();

    void addCustomer(Customer customer);

    void update(Customer customer);

    void delete(Customer customer);
}

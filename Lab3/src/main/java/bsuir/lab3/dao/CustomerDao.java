package bsuir.lab3.dao;

import bsuir.lab3.model.Customer;
import jakarta.ejb.Local;


@Local
public interface CustomerDao {

    Customer findCustomerById(Long id);

    Customer addCustomer(Customer customer);
}

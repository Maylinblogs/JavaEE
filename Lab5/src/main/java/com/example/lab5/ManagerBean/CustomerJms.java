package com.example.lab5.ManagerBean;

import com.example.lab5.dao.CustomerDao;
import com.example.lab5.model.Customer;
import jakarta.annotation.ManagedBean;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Vector;

@ManagedBean
@RequestScoped
@Named(value = "customerController")
@Getter
@Setter
public class CustomerJms implements Serializable {

    @EJB(beanName = "customerDao")
    private CustomerDao customerDao;
    private Long id;
    private Customer customer = new Customer();

    private Customer customerSearch = new Customer();

    public void addCustomer() {
        customerDao.addCustomer(customer);
    }

    public void updateCustomer() {
        customerDao.update(customer);
    }

    public void searchCustomer() {
        customerSearch = customerDao.findCustomerById(id);
    }

    public Vector<Customer> allCustomers() {
        return (Vector<Customer>) customerDao.allCustomers();
    }

    public void deleteCustomer() {
        Customer customer = customerDao.findCustomerById(id);
        customerDao.delete(customer);
    }
}

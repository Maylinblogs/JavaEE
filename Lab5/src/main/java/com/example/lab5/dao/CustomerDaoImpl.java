package com.example.lab5.dao;


import com.example.lab5.model.Customer;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;


@Stateless(name = "customerDao")
public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext(unitName = "MySqlPersist")
    private EntityManager entityManager;

    @Override
    public Customer findCustomerById(Long customerId) {
        Customer customer = null;
        try {
            customer = entityManager.find(Customer.class, customerId);
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Logger.Level.INFO, e.getMessage());
        }
        return customer;
    }

    @Override
    public List<Customer> allCustomers() {
        return (List<Customer>) entityManager.createQuery("select c from Customer c")
                .getResultList();
    }

    @Override
    public void addCustomer(Customer customer) {
        try {
            entityManager.persist(customer);
        } catch (Exception e) {
            // Logger.getLogger(getClass().getName()).log(Logger.Level.INFO, e.getMessage());
        }
    }

    @Override
    public void update(Customer customer) {
        try {
            entityManager.merge(customer);
        } catch (Exception e) {
            // Logger.getLogger(getClass().getName()).log(Logger.Level.INFO, e.getMessage());
        }
    }

    @Override
    public void delete(Customer customer) {
        Customer removed = entityManager.merge(customer);
        entityManager.remove(removed);
    }
}

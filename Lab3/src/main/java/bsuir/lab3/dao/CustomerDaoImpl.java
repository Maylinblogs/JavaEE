package bsuir.lab3.dao;

import bsuir.lab3.model.Customer;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Stateless(name = "customerDao")
public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext(unitName = "MySqlPersist")
    private EntityManager entityManager;

    @Override
    public Customer findCustomerById(Long customerId) {
        Customer customer = null;
        try {
            customer = entityManager.find(Customer.class,customerId);
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Logger.Level.INFO, e.getMessage());
        }
        return customer;
    }


    @Override
    public Customer addCustomer(Customer customer) {
        try {
            entityManager.persist(customer);
        } catch (Exception e) {
           // Logger.getLogger(getClass().getName()).log(Logger.Level.INFO, e.getMessage());
        }
        return customer;
    }
}

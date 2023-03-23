package com.example.lab5.dao;

import com.example.lab5.model.City;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless(name = "CityDaoImpl")
public class CityDaoImpl implements CityDao {

    @PersistenceContext(unitName = "MySqlPersist")
    private EntityManager entityManager;

    @Override
    public City findCustomerById(Long id) {
        City city = null;
        try {
            city = entityManager.find(City.class, id);
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Logger.Level.INFO, e.getMessage());
        }
        return city;
    }

    @Override
    public List<City> allCities() {
        return (List<City>) entityManager.createQuery("select c from City c")
                .getResultList();
    }

    @Override
    public void addCity(City city) {
        try {
            entityManager.persist(city);
        } catch (Exception e) {
            // Logger.getLogger(getClass().getName()).log(Logger.Level.INFO, e.getMessage());
        }
    }

    @Override
    public void update(City city) {
        try {
            entityManager.merge(city);
        } catch (Exception e) {
            // Logger.getLogger(getClass().getName()).log(Logger.Level.INFO, e.getMessage());
        }
    }

    @Override
    public void delete(City city) {
        City removed = entityManager.merge(city);
        entityManager.remove(removed);
    }
}

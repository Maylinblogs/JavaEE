package com.example.lab5.ManagerBean;

import com.example.lab5.dao.CityDao;
import com.example.lab5.model.City;
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
@Named(value = "cityController")
@Getter
@Setter
public class CityJms implements Serializable {
    @EJB(beanName = "CityDaoImpl")
    private CityDao cityDao;

    private City city = new City();

    private City citySearch = new City();
    private Long id;

    public void addCity() {
        cityDao.addCity(city);
    }

    public void updateCustomer() {
        cityDao.update(city);
    }

    public void searchCustomer() {
        citySearch = cityDao.findCustomerById(id);
    }

    public Vector<City> allCities() {
        return (Vector<City>) cityDao.allCities();
    }

    public void deleteCustomer() {
        City city = cityDao.findCustomerById(id);
        cityDao.delete(city);
    }
}

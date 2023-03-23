package com.example.lab5.dao;

import com.example.lab5.model.City;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface CityDao {

    City findCustomerById(Long id);

    List<City> allCities();

    void addCity(City city);

    void update(City city);

    void delete(City city);
}

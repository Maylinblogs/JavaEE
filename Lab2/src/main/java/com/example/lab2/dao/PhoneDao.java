package com.example.lab2.dao;

import com.example.lab2.model.Phone;
import jakarta.ejb.Local;

import java.util.ArrayList;

@Local
public interface PhoneDao {

    void delete(String model, String category);

    ArrayList<Phone> allPhone();

    Phone search(String model, Boolean yes);
}

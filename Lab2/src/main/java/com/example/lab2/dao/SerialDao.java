package com.example.lab2.dao;

import com.example.lab2.model.Phone;
import com.example.lab2.model.Serial;
import jakarta.ejb.Local;

import java.util.ArrayList;

@Local

public interface SerialDao {
    ArrayList<Serial> allSerials();


}

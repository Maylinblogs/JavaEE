package com.example.lab2.dao;

import com.example.lab2.model.Serial;
import jakarta.ejb.Stateless;

import java.util.ArrayList;

@Stateless(name = "SerialDao")

public class SerialDaoImpl implements SerialDao {

    private static final ArrayList<Serial> serials = new ArrayList<>();

    static {
        serials.add(Serial
                .builder().id(1L)
                .name("NNN")
                .score(1)
                .episode(80)
                .build());
        serials.add(Serial
                .builder().id(2L)
                .name("New")
                .score(2)
                .episode(87)
                .build());
        serials.add(Serial
                .builder().id(3L)
                .name("123123")
                .score(3)
                .episode(85)
                .build());
        serials.add(Serial
                .builder().id(4L)
                .name("New")
                .score(4)
                .episode(85)
                .build());
    }



    @Override
    public ArrayList<Serial> allSerials() {
        return serials;
    }
}
package com.example.lab2.dao;

import com.example.lab2.model.Phone;
import jakarta.ejb.Stateless;

import java.util.ArrayList;

@Stateless(name = "phoneDao")
public class PhoneDaoImpl implements PhoneDao {
    private static final ArrayList<Phone> phones = new ArrayList<>();

    static {
        phones.add(Phone
                .builder().id(1L)
                .category("NNN")
                .yes(true)
                .price(80.0)
                .model("SAMSUNG")
                .build());
        phones.add(Phone
                .builder().id(2L)
                .category("New")
                .yes(true)
                .price(87.0)
                .model("NOKIA")
                .build());
        phones.add(Phone
                .builder().id(3L)
                .category("123123")
                .yes(false)
                .price(85.0)
                .model("XIAOMI")
                .build());
        phones.add(Phone
                .builder().id(4L)
                .category("New")
                .yes(false)
                .price(85.0)
                .model("APPLE")
                .build());
    }

    @Override
    public void delete(String model, String category) {
        phones.removeIf(p -> p.getModel().equals(model) && p.getCategory().equals(category));
    }

    @Override
    public ArrayList<Phone> allPhone() {
        return phones;
    }

    @Override
    public Phone search(String model, Boolean yes) {
        for (Phone p : phones) {
            if (p.getModel().equals(model) && p.getYes().equals(yes)) {
                return p;
            }
        }
        return new Phone();
    }
}

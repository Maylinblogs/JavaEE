package com.example.lab2.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Phone implements Serializable {

    private Long id;

    private String category;

    private String model;

    private Double price;

    private Boolean yes;

}

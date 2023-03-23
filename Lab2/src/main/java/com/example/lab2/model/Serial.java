package com.example.lab2.model;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Serial implements Serializable {

    private Long id;

    private String name;

    private int score;

    private int episode;
}

package bsuir.lab3.model;

import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String name;

    private String address;

    private String address2;

    private String email;

    private String city;

}

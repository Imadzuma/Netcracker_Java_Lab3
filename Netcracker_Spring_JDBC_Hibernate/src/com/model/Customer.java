package com.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name="customers")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name="last_name", nullable = false)
    private String lastName;

    @Column (name="district", nullable = false)
    private String district;

    @Column (name="sale", nullable = false)
    private Double sale;
}

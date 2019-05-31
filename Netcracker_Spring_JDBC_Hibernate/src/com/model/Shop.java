package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name="shops")
@Data
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name="name", nullable = false)
    private String name;

    @Column (name="district", nullable = false)
    private String district;

    @Column (name="commission", nullable = false)
    private Double commission;
}

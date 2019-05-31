package com.netcracker.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="customers2")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="id")
    private Integer id;

    @Column (name="last_name", nullable = false)
    private String lastName;

    @Column (name="district", nullable = false)
    private String district;

    @Column (name="sale", nullable = false)
    private Double sale;
}

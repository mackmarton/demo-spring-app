package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MY_ENTITY")
@Data
public class MyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MY_ENTITY_SEQ_GEN")
    @SequenceGenerator(name = "MY_ENTITY_SEQ_GEN", sequenceName = "MY_ENTITY_SEQ", allocationSize = 1)
    @Column(name = "Id")
    private Long id;
    @Column(name = "name")
    private String name;
}

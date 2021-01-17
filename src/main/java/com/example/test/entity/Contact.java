package com.example.test.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="CONTACTS")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(name="full_name")
    private String fullName;
    @Column(name="email", nullable = false, length = 200)
    private String email;
    @Column(name="telephone")
    private String telephone;
}

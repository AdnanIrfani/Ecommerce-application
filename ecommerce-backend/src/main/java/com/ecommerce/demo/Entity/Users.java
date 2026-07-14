package com.ecommerce.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name",nullable = false)
    String name;

    @Column(name = "email",nullable = false)
    String email;

    @Column(name = "phone",nullable = true)
    Integer phone;

    @Column(name = "address",nullable = true)
    String address;

    @Column(name = "password",nullable = false)
    String password;

}

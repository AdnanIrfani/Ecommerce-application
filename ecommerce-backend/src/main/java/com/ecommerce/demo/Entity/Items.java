package com.ecommerce.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "item")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "item_name",nullable = false)
    String item_name;

    @Column(name = "item_category",nullable = false)
    String item_category;

    @Column(name = "item_desc",nullable = false)
    String item_desc;

    @Column(name = "price",nullable = false)
    Double price;

    @Column(name = "stock",nullable = false)
    Integer stock;
}

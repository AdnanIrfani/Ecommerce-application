package com.ecommerce.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class OrderItem {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name="order_id")
        private Orders order;

        @ManyToOne
        @JoinColumn(name="item_id")
        private Items item;

        private int quantity;

        private double price;

}

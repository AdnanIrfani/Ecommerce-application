package com.ecommerce.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;

import java.time.LocalDate;

@Data
@Entity
public class Orders {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name="user_id")
        private Users user;

        private LocalDate orderDate;

        private Double totalAmount;

}


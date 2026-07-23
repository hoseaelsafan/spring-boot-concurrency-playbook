package com.dee.concurrency.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer stock;
}

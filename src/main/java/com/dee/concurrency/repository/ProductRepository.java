package com.dee.concurrency.repository;

import com.dee.concurrency.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

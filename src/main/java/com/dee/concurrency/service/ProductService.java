package com.dee.concurrency.service;

import com.dee.concurrency.dto.Productdto;

import java.util.List;

public interface ProductService {
    List<Productdto> catalog();
    void purchase(Long productId, Integer quantity);
}

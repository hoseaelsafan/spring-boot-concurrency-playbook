package com.dee.concurrency.service;

import com.dee.concurrency.dto.Productdto;
import com.dee.concurrency.entity.Product;
import com.dee.concurrency.mapper.ProductMapper;
import com.dee.concurrency.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private static final Logger actLog =
            LoggerFactory.getLogger("TRX_LOGGER");

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<Productdto> catalog() {
        var products = productRepository.findAll();
        System.out.println(products);
        return productMapper.toResponslist(products);
    }

    @Transactional
    public void purchase(Long productId, Integer quantity) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        if (product.getStock() < quantity) {
            actLog.info("Insufficient stock");
            throw new RuntimeException("Insufficient stock");
        }

        product.setStock(product.getStock() - quantity);

        productRepository.save(product);
        actLog.info("Transaksi succes");
    }
}


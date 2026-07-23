package com.dee.concurrency.controller;

import com.dee.concurrency.dto.PurchaseReq;
import com.dee.concurrency.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final ProductService productService;

    public PurchaseController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> buy(@PathVariable Long id, @RequestBody PurchaseReq req){
        productService.purchase(id, req.Quantity());
        return ResponseEntity.ok().build();
    }
}

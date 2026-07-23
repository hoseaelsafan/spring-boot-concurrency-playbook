package com.dee.concurrency.dto;

import jakarta.validation.constraints.Min;

public record PurchaseReq(
        @Min(1)
        Integer Quantity) {
}

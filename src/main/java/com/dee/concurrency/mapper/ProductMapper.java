package com.dee.concurrency.mapper;

import com.dee.concurrency.dto.Productdto;
import com.dee.concurrency.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Productdto toRespons(Product product);

    List<Productdto> toResponslist(
            List<Product> products
    );
}

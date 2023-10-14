package com.example.wherehouse.service.mapper;

import com.example.wherehouse.dto.ProductDto;
import com.example.wherehouse.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductDto productDto);
    ProductDto toDto(Product product);
}

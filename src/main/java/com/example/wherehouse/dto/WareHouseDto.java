package com.example.wherehouse.dto;

import com.example.wherehouse.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WareHouseDto {
    private Long id;
    private String name;
    private List<Product> products;
}

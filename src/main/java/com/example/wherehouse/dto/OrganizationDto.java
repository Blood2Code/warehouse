package com.example.wherehouse.dto;

import com.example.wherehouse.entity.WareHouse;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizationDto {
    private Long id;
    private String name;
    private Integer userLoginId;
    private List<WareHouse> whereHouse;

}

package com.example.wherehouse.service.mapper;

import com.example.wherehouse.dto.WareHouseDto;
import com.example.wherehouse.entity.WareHouse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WareHouseMapper {
    WareHouse toEntity(WareHouseDto warehouseDto);
    WareHouseDto toDto(WareHouse warehouse);
}

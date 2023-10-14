package com.example.wherehouse.service.mapper;

import com.example.wherehouse.dto.OrganizationDto;
import com.example.wherehouse.entity.Organization;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {
    Organization toEntity(OrganizationDto organizationDto);
    OrganizationDto toDto(Organization organization);
}

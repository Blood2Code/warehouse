package com.example.wherehouse.service;

import com.example.wherehouse.dto.OrganizationDto;
import com.example.wherehouse.dto.ResponseDto;
import com.example.wherehouse.repository.OrganizationRepository;
import com.example.wherehouse.service.mapper.OrganizationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;

    public ResponseDto createOrganization(OrganizationDto organizationDto) {
        if (organizationDto.getId() != null && organizationDto.getUserLoginId() > 0) {
            organizationRepository.save(organizationMapper.toEntity(organizationDto));
        }
        return ResponseDto.builder()
                .success(true)
                .code(0)
                .data(organizationDto)
                .build();
    }


}

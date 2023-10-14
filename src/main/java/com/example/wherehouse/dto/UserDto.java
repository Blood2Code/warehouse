package com.example.wherehouse.dto;

import com.example.wherehouse.entity.Organization;
import com.example.wherehouse.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(value = {"password", "email"})
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private List<Organization> organizations;
}

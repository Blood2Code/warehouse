package com.example.wherehouse.entity;

import com.example.wherehouse.enums.Action;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer amount;
    private String measurement;
    @Enumerated(EnumType.STRING)
    private Action action;
}

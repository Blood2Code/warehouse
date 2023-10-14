package com.example.wherehouse.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "u_organization")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Organization {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    @OneToMany
    private List<WareHouse> whereHouse;

}

package com.waste.waste_management.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "areas", schema = "waste_schema")  // Add schema here
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
}


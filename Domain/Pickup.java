package com.waste.waste_management.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pickups", schema = "waste_schema")  // Specify schema here
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pickup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private LocalDateTime scheduledTime;
    private boolean completed;
}

package com.open.source.health.center.system.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "health_center")
public class HealthCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private HealthCenterType type;

    @Column(name = "infrastructure_score")
    private int infrastructureScore;

    @Column(name = "service_score")
    private int serviceScore;

    @Column(name = "has_ambulance")
    private boolean hasAmbulance;

}

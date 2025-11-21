package com.open.source.health.center.system.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class HealthCenterDto {

    private Long id;

    private String name;

    private HealthCenterTypeDto type;

    private int infrastructureScore;

    private int serviceScore;

    private boolean hasAmbulance;

    public double calculateRating() {
        return infrastructureScore * 0.35 + serviceScore * 0.65;
    }

    public boolean isApproved() {
        return calculateRating() >= 80;
    }
}

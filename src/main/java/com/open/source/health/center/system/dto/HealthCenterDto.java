package com.open.source.health.center.system.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class HealthCenterDto {

    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private HealthCenterTypeDto type;

    @Min(value = 1)
    @Max(value = 100)
    private int infrastructureScore;

    @Min(value = 1)
    @Max(value = 100)
    private int serviceScore;

    @NotNull
    private boolean hasAmbulance;

    public double calculateRating() {
        return infrastructureScore * 0.35 + serviceScore * 0.65;
    }

    public boolean isApproved() {
        return calculateRating() >= 80;
    }
}

package com.open.source.health.center.system.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class HealthCenterRatingDto {

    private static double INFRASTRUCTURE_WEIGHT = 0.35;
    private static double SERVICE_WEIGHT  = 0.65;
    private static final double MIN_APPROVAL_SCORE = 80.0;


    public Long id;
    public String name;
    public String type;
    public double rating;
    public boolean approved;

    public static double calculateRating(int infrastructureRating, int serviceRating) {
        return (infrastructureRating * INFRASTRUCTURE_WEIGHT) + (serviceRating * SERVICE_WEIGHT);
    }

    public static boolean isApproved(double rating){
        return rating >= 80;
    }

}

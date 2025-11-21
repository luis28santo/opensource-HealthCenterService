package com.open.source.health.center.system.service;

import com.open.source.health.center.system.dto.HealthCenterDto;
import com.open.source.health.center.system.entity.HealthCenter;
import com.open.source.health.center.system.entity.HealthCenterType;
import com.open.source.health.center.system.repository.HealthCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HealthCenterServiceImpl implements HealthCenterService {

    private final HealthCenterRepository healthCenterRepository;

    @Override
    public HealthCenterDto save(HealthCenterDto healthCenterDto) {

        HealthCenter healthCenter = HealthCenter.builder()
                .type(HealthCenterType.builder()
                        .id(healthCenterDto.getType().getId())
                        .name(healthCenterDto.getType().getName())
                        .build())
                .hasAmbulance(healthCenterDto.isHasAmbulance())
                .serviceScore(healthCenterDto.getServiceScore())
                .infrastructureScore(healthCenterDto.getInfrastructureScore())
                .name(healthCenterDto.getName())
                .build();

        healthCenter = this.healthCenterRepository.save(healthCenter);
        healthCenterDto.setId(healthCenter.getId());
        return healthCenterDto;
    }

}

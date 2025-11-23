package com.open.source.health.center.system.service;

import com.open.source.health.center.system.dto.HealthCenterDto;
import com.open.source.health.center.system.dto.HealthCenterTypeDto;
import com.open.source.health.center.system.entity.HealthCenter;
import com.open.source.health.center.system.entity.HealthCenterType;
import com.open.source.health.center.system.repository.HealthCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<HealthCenterDto> findByName(String name) {
        return this.healthCenterRepository.findByName(name)
                .map(item ->
                        HealthCenterDto.builder()
                                .id(item.getId())
                                .type(HealthCenterTypeDto.builder()
                                        .id(item.getType().getId())
                                        .name(item.getType().getName())
                                        .build())
                                .name(item.getName())
                                .serviceScore(item.getServiceScore())
                                .infrastructureScore(item.getInfrastructureScore())
                                .hasAmbulance(item.isHasAmbulance())
                                .build()
                );
    }

    @Override
    public List<HealthCenterDto> list() {
        return this.healthCenterRepository.findAll().stream()
                .map(item -> HealthCenterDto.builder()
                        .id(item.getId())
                        .type(HealthCenterTypeDto.builder()
                                .id(item.getType().getId())
                                .name(item.getType().getName())
                                .build())
                        .name(item.getName())
                        .serviceScore(item.getServiceScore())
                        .infrastructureScore(item.getInfrastructureScore())
                        .hasAmbulance(item.isHasAmbulance())
                        .build())
                .toList();
    }

    @Override
    public Optional<HealthCenterDto> getById(Long id) {
        return this.healthCenterRepository.findById(id).map(item ->
                HealthCenterDto.builder()
                        .id(item.getId())
                        .type(HealthCenterTypeDto.builder()
                                .id(item.getType().getId())
                                .name(item.getType().getName())
                                .build())
                        .name(item.getName())
                        .serviceScore(item.getServiceScore())
                        .infrastructureScore(item.getInfrastructureScore())
                        .hasAmbulance(item.isHasAmbulance())
                        .build()
        );
    }

}

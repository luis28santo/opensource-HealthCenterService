package com.open.source.health.center.system.manager;

import com.open.source.health.center.system.dto.HealthCenterDto;
import com.open.source.health.center.system.service.HealthCenterService;
import com.open.source.health.center.system.service.HealthCenterTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HealthCenterManager {

    private final HealthCenterService healthCenterService;
    private final HealthCenterTypeService healthCenterTypeService;

    public HealthCenterDto register(HealthCenterDto healthCenterDto) {

        this.healthCenterTypeService.findById(healthCenterDto.getType().getId())
                .orElseThrow(() -> new RuntimeException("El tipo no existe"));

        return this.healthCenterService.save(healthCenterDto);
    }


}

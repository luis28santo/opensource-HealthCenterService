package com.open.source.health.center.system.service;

import com.open.source.health.center.system.dto.HealthCenterDto;
import com.open.source.health.center.system.entity.HealthCenter;

import java.util.List;
import java.util.Optional;

public interface HealthCenterService {

    HealthCenterDto save(HealthCenterDto healthCenter);

    Optional<HealthCenterDto> findByName(String name);

    List<HealthCenterDto> list();

    Optional<HealthCenterDto> getById(Long id);
}

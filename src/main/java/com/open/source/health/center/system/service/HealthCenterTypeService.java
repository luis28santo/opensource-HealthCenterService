package com.open.source.health.center.system.service;

import com.open.source.health.center.system.dto.HealthCenterTypeDto;

import java.util.List;
import java.util.Optional;

public interface HealthCenterTypeService {

    List<HealthCenterTypeDto> list();

    Optional<HealthCenterTypeDto> findById(Long id);

}

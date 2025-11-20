package com.open.source.health.center.system.repository;

import com.open.source.health.center.system.entity.HealthCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthCenterRepository extends JpaRepository<HealthCenter, Long> {

    List<HealthCenter> findByTypeId(Long typeId);

}

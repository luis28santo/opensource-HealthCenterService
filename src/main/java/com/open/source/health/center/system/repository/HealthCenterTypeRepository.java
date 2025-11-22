package com.open.source.health.center.system.repository;

import com.open.source.health.center.system.entity.HealthCenterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthCenterTypeRepository extends JpaRepository<HealthCenterType, Long> {

}

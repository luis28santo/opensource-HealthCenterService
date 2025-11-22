package com.open.source.health.center.system.repository;

import com.open.source.health.center.system.entity.HealthCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HealthCenterRepository extends JpaRepository<HealthCenter, Long> {

    List<HealthCenter> findByTypeId(Long typeId);

    Optional<HealthCenter> findByName(String name);

}

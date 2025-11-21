package com.open.source.health.center.system.service;

import com.open.source.health.center.system.dto.HealthCenterTypeDto;
import com.open.source.health.center.system.repository.HealthCenterTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HealthCenterTypeServiceImpl implements HealthCenterTypeService {

    private HealthCenterTypeRepository repository;

    @Override
    public List<HealthCenterTypeDto> list() {
        return repository.findAll().stream()
                .map(entity ->
                        HealthCenterTypeDto.builder()
                                .id(entity.getId())
                                .name(entity.getName())
                                .build())
                .toList();
    }

    @Override
    public Optional<HealthCenterTypeDto> findById(Long id) {
        return this.repository.findById(id)
                .map(entity ->
                        HealthCenterTypeDto.builder()
                                .id(entity.getId())
                                .name(entity.getName())
                                .build());
    }

}

package com.open.source.health.center.system.manager;

import com.open.source.health.center.system.dto.HealthCenterDto;
import com.open.source.health.center.system.dto.HealthCenterRatingDto;
import com.open.source.health.center.system.dto.HealthCenterTypeDto;
import com.open.source.health.center.system.service.HealthCenterService;
import com.open.source.health.center.system.service.HealthCenterTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HealthCenterManager {

    private final HealthCenterService healthCenterService;
    private final HealthCenterTypeService healthCenterTypeService;

    public void register(HealthCenterDto healthCenterDto) {

        this.healthCenterTypeService.findById(healthCenterDto.getType().getId())
                .orElseThrow(() -> new RuntimeException("El tipo no existe"));

        Optional<HealthCenterDto> opt = this.healthCenterService.findByName(healthCenterDto.getName());

        if(opt.isPresent() && opt.get().getName().equalsIgnoreCase(healthCenterDto.getName())){
            throw new RuntimeException("El nombre del centro ya existe.");
        }

        this.healthCenterService.save(healthCenterDto);
    }

    public List<HealthCenterTypeDto> typeList (){
        return this.healthCenterTypeService.list();
    }

    public List<HealthCenterDto> getAll(){
        return this.healthCenterService.list();
    }

    public List<HealthCenterRatingDto> getAllWithRating(){
        return this.healthCenterService.list()
                .stream().map(item -> {

                    double rating = HealthCenterRatingDto.calculateRating(item.getInfrastructureScore(), item.getServiceScore());
                    boolean approved = HealthCenterRatingDto.isApproved(rating);

                    return HealthCenterRatingDto
                            .builder()
                            .id(item.getId())
                            .name(item.getName())
                            .type(item.getType().getName())
                            .rating(rating)
                            .approved(approved)
                            .build();

                })
                .toList();
    }

    public List<HealthCenterDto> getTypeCentroSalud(int idTipoCentro){

        return this.healthCenterService.list()
                .stream()
                .filter(c -> c.getType().getId() == idTipoCentro)
                .toList();
    }

    public Boolean getWithRatingStatus(int idCentro){

        return this.healthCenterService.list()
                .stream().map(item -> {

                    double rating = HealthCenterRatingDto.calculateRating(item.getInfrastructureScore(), item.getServiceScore());
                    boolean approved = HealthCenterRatingDto.isApproved(rating);

                    return HealthCenterRatingDto
                            .builder()
                            .id(item.getId())
                            .name(item.getName())
                            .type(item.getType().getName())
                            .rating(rating)
                            .approved(approved)
                            .build();

                })
                .filter(c -> c.getId() == idCentro)
                .findFirst()
                .map(c -> c.isApproved())
                .orElse(false);


    }

}

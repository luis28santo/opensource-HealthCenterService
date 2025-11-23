package com.open.source.health.center.system.controller;

import com.open.source.health.center.system.dto.HealthCenterDto;
import com.open.source.health.center.system.dto.HealthCenterRatingDto;
import com.open.source.health.center.system.dto.HealthCenterTypeDto;
import com.open.source.health.center.system.entity.UpdateNameHealthCenterRequest;
import com.open.source.health.center.system.manager.HealthCenterManager;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/healthCenter")
public class HealthCenterController {

    private final HealthCenterManager manager;

    @GetMapping("/types")
    public ResponseEntity<List<HealthCenterTypeDto>> typeList() {
        return ResponseEntity.ok(this.manager.typeList());
    }

    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody HealthCenterDto dto){

        this.manager.register(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("success", true));
    }

    @GetMapping
    public ResponseEntity<List<HealthCenterDto>> getAll(){
        return ResponseEntity.ok(this.manager.getAll());
    }

    @GetMapping("/withRating")
    public ResponseEntity<List<HealthCenterRatingDto>> getAllWithRating(){
        return ResponseEntity.ok(this.manager.getAllWithRating());
    }
    @GetMapping("/centerTypes")
    public ResponseEntity<List<HealthCenterDto>> getTypeCentroSalud(int idTipoCentro){

        return ResponseEntity.ok(this.manager.getTypeCentroSalud(idTipoCentro));
    }

    @GetMapping("/withRatingStatus")
    public ResponseEntity<Map<String, Boolean>> getWithRatingStatus(int idCentro){

        boolean approved = this.manager.getWithRatingStatus(idCentro);

        return ResponseEntity.ok(Map.of("approved", approved));

    }

    @PutMapping("/name/{id}")
    public ResponseEntity<?> updateNameHealthCenter(@PathVariable Long id, @Valid @RequestBody UpdateNameHealthCenterRequest request){
        this.manager.updateNameHealthCenter(id, request.getName());
        return ResponseEntity.ok(Collections.singletonMap("success", true));
    }


}

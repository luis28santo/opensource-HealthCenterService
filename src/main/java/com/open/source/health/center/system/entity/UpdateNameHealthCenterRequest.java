package com.open.source.health.center.system.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateNameHealthCenterRequest {
    @NotBlank
    private String name;
}

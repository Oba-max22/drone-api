package com.emmanuel.macaulay.dronesapi.payload.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Max;
import java.math.BigDecimal;

@Builder
@Getter
public class RegisterRequest {

    private String model;

    @Max(500)
    private Integer weightLimit;

    private BigDecimal batteryCapacity;

    private String state;
}

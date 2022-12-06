package com.emmanuel.macaulay.dronesapi.model;

import com.emmanuel.macaulay.dronesapi.enums.Model;
import com.emmanuel.macaulay.dronesapi.enums.State;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Drone extends BaseEntity {

    @Size(max=500)
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long serialNumber;

    @Enumerated(EnumType.ORDINAL)
    private Model model;

    @Max(500)
    private Integer weightLimit;

    @Column(precision = 5, scale = 4)
    private BigDecimal batteryCapacity;

    @Enumerated(EnumType.ORDINAL)
    private State state;
}

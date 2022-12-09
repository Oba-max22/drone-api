package com.emmanuel.macaulay.dronesapi.model;

import com.emmanuel.macaulay.dronesapi.enums.Model;
import com.emmanuel.macaulay.dronesapi.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max=100)
    private String serialNumber;

    @Enumerated(EnumType.ORDINAL)
    private Model model;

    @Max(500)
    private Integer weightLimit;

    @Column(precision = 5, scale = 4)
    private BigDecimal batteryCapacity;

    @Enumerated(EnumType.ORDINAL)
    private State state;

    @OneToMany( fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Medication> medicationList;
}

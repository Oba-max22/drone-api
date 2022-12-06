package com.emmanuel.macaulay.dronesapi.model;

import jakarta.persistence.Entity;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Medication extends BaseEntity {

    @Pattern(regexp="^[A-Za-z0-9_-]*$", message="only letters, numbers, underscore and '-' are allowed")
    private String name;

    private Integer weight;

    @Pattern(regexp="^[A-Z0-9_]*$", message="only upper case letters, underscore and numbers are allowed")
    private String code;

    private String image;
}

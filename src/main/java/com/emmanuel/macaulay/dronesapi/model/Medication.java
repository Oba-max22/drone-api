package com.emmanuel.macaulay.dronesapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Medication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp="^[A-Za-z0-9_-]*$", message="only letters, numbers, underscore and '-' are allowed")
    private String name;

    private Integer weight;

    @Pattern(regexp="^[A-Z0-9_]*$", message="only upper case letters, underscore and numbers are allowed")
    private String code;

    private String image;
}

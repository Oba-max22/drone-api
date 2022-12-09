package com.emmanuel.macaulay.dronesapi.repository;

import com.emmanuel.macaulay.dronesapi.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
    Optional<Medication> findMedicationByCode(String code);
}

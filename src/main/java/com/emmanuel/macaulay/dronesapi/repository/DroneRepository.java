package com.emmanuel.macaulay.dronesapi.repository;

import com.emmanuel.macaulay.dronesapi.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
}

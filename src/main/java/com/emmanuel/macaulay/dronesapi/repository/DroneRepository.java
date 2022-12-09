package com.emmanuel.macaulay.dronesapi.repository;

import com.emmanuel.macaulay.dronesapi.enums.State;
import com.emmanuel.macaulay.dronesapi.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
    Optional<Drone> findDroneBySerialNumber(String serialNumber);

    List<Drone> findDronesByStateIn(List<State> stateList);
}

package com.emmanuel.macaulay.dronesapi.service;

import com.emmanuel.macaulay.dronesapi.enums.Model;
import com.emmanuel.macaulay.dronesapi.enums.State;
import com.emmanuel.macaulay.dronesapi.exception.LowBatteryException;
import com.emmanuel.macaulay.dronesapi.exception.ResourceNotFoundException;
import com.emmanuel.macaulay.dronesapi.exception.UnavailableForLoadingException;
import com.emmanuel.macaulay.dronesapi.model.Drone;
import com.emmanuel.macaulay.dronesapi.model.Medication;
import com.emmanuel.macaulay.dronesapi.payload.request.RegisterRequest;
import com.emmanuel.macaulay.dronesapi.repository.DroneRepository;
import com.emmanuel.macaulay.dronesapi.repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DroneServiceImplementation implements DroneService {

    private final DroneRepository droneRepository;
    private final MedicationRepository medicationRepository;

    @Override
    public Drone registerDrone(RegisterRequest registerRequest) {
        Drone drone = Drone.builder()
                .serialNumber(UUID.randomUUID().toString())
                .model(modelAdapter(registerRequest.getModel()))
                .weightLimit(registerRequest.getWeightLimit())
                .batteryCapacity(registerRequest.getBatteryCapacity())
                .state(stateAdapter(registerRequest.getState()))
                .build();

        return droneRepository.save(drone);
    }

    private State stateAdapter(String state) {
        try {
            return State.valueOf(state.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private Model modelAdapter(String model) {
        try {
            return Model.valueOf(model.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}

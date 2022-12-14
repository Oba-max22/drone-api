package com.emmanuel.macaulay.dronesapi.service;

import com.emmanuel.macaulay.dronesapi.model.Drone;
import com.emmanuel.macaulay.dronesapi.model.Medication;
import com.emmanuel.macaulay.dronesapi.payload.request.RegisterRequest;
import com.emmanuel.macaulay.dronesapi.payload.response.DroneBatteryResponse;

import java.util.List;

public interface DroneService {

    Drone registerDrone(RegisterRequest registerRequest);

    Drone loadDroneWithMedication(String serialNumber, String medicationCode);

    List<Medication> getLoadedMedication(String serialNumber);

    List<Drone> getAvailableDrones();

    DroneBatteryResponse getBatteryLevel(String serialNumber);
}

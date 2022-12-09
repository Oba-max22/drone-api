package com.emmanuel.macaulay.dronesapi.controller;

import com.emmanuel.macaulay.dronesapi.model.Drone;
import com.emmanuel.macaulay.dronesapi.model.Medication;
import com.emmanuel.macaulay.dronesapi.payload.request.RegisterRequest;
import com.emmanuel.macaulay.dronesapi.payload.response.ApiResponse;
import com.emmanuel.macaulay.dronesapi.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/drone")
@RestController
public class DispatchController {
    private static final String DRONE_REGISTER_SUCCESS = "Drone registered successfully!";

    private final DroneService droneService;

    @PostMapping("/register")
    public ResponseEntity<?> registerDrone(@RequestBody RegisterRequest registerRequest) {
        ApiResponse<Drone> apiResponse = new ApiResponse<>(DRONE_REGISTER_SUCCESS,
                droneService.registerDrone(registerRequest));
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PutMapping(value="/{serialNumber}/load/{medicationCode}")
    public ResponseEntity<?> loadDrone(@PathVariable(value = "serialNumber") String serialNumber,
                                       @PathVariable(value = "medicationCode") String medicationCode){
        ApiResponse<Drone> apiResponse = new ApiResponse<>("Loading successful", droneService.loadDroneWithMedication(serialNumber, medicationCode));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping(value="/{serialNumber}/medication")
    public ResponseEntity<?> getLoadedMedication(@PathVariable(value = "serialNumber") String serialNumber){
        ApiResponse<List<Medication>> apiResponse = new ApiResponse<>("Loaded medication", droneService.getLoadedMedication(serialNumber));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping(value="/available")
    public ResponseEntity<?> getAvailableDrones(){
        ApiResponse<List<Drone>> apiResponse = new ApiResponse<>("Available drones", droneService.getAvailableDrones());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    // TODO check drone battery level for a given drone;
}

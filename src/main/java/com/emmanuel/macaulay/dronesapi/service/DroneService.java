package com.emmanuel.macaulay.dronesapi.service;

import com.emmanuel.macaulay.dronesapi.model.Drone;
import com.emmanuel.macaulay.dronesapi.payload.request.RegisterRequest;

public interface DroneService {

    Drone registerDrone(RegisterRequest registerRequest);

}

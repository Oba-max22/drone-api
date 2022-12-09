package com.emmanuel.macaulay.dronesapi.payload.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DroneBatteryResponse {
    private String serialNumber;
    private Double batteryLevel;
}

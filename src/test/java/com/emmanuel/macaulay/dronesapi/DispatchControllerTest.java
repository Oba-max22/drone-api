package com.emmanuel.macaulay.dronesapi;

import com.emmanuel.macaulay.dronesapi.controller.DispatchController;
import com.emmanuel.macaulay.dronesapi.enums.Model;
import com.emmanuel.macaulay.dronesapi.enums.State;
import com.emmanuel.macaulay.dronesapi.model.Drone;
import com.emmanuel.macaulay.dronesapi.payload.request.RegisterRequest;
import com.emmanuel.macaulay.dronesapi.service.DroneService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DispatchControllerTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DispatchController dispatchController;

    @MockBean
    private DroneService droneService;

    @Test
    public void contextLoads() {
        assertThat(dispatchController).isNotNull();
        assertThat(droneService).isNotNull();
    }

    @Test
    @DisplayName("Register Drone")
    public void shouldRegisterDrone() throws Exception {

        RegisterRequest registerRequest = RegisterRequest.builder()
                .model("LIGHT_WEIGHT")
                .weightLimit(125)
                .batteryCapacity(BigDecimal.valueOf(100.00))
                .state("IDLE")
                .build();

        Drone drone =  Drone.builder().model(Model.LIGHT_WEIGHT)
                .weightLimit(125)
                .batteryCapacity(BigDecimal.valueOf(100.00))
                .state(State.IDLE).build();
        when(droneService.registerDrone(any(RegisterRequest.class))).thenReturn(drone);

        this.mockMvc.perform(post("/drone/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(registerRequest)).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message", Is.is("Drone registered successfully!")))
                .andExpect(jsonPath("$.data.weightLimit", Is.is(125)))
                .andExpect(jsonPath("$.data.batteryCapacity", Is.is(100.0)))
                .andExpect(jsonPath("$.data.state", Is.is("IDLE")));

        verify(droneService, times(1)).registerDrone(any(RegisterRequest.class));
    }

}

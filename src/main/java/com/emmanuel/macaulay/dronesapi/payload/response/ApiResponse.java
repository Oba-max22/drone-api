package com.emmanuel.macaulay.dronesapi.payload.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Timestamp timestamp;

    private T data;

    private ApiResponse() {
        timestamp = Timestamp.valueOf(LocalDateTime.now());
    }

    public ApiResponse(String message) {
        this();
        this.message = message;
    }

    public ApiResponse(String message, T data) {
        this();
        this.message = message;
        this.data = data;
    }

}

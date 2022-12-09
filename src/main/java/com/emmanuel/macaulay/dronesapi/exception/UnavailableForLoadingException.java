package com.emmanuel.macaulay.dronesapi.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@Data
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UnavailableForLoadingException extends RuntimeException {

    private String message;

    public UnavailableForLoadingException(String message) {
        this.message = message;
    }
}
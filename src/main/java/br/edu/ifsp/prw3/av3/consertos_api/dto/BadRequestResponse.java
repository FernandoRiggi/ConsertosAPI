package br.edu.ifsp.prw3.av3.consertos_api.dto;

import org.springframework.validation.FieldError;

public record BadRequestResponse(String field, String message) {
    public BadRequestResponse(FieldError fieldError) {
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }
}

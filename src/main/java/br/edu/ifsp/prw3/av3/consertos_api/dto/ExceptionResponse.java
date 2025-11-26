package br.edu.ifsp.prw3.av3.consertos_api.dto;

import java.time.LocalDateTime;

public record ExceptionResponse(int code, String message, LocalDateTime timestamp) {
}

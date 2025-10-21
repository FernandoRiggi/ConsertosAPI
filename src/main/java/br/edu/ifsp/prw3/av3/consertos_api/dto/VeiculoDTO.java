package br.edu.ifsp.prw3.av3.consertos_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record VeiculoDTO(
        @NotBlank
        String marca,
        @NotBlank
        String modelo,
        @NotBlank
        @Pattern(regexp = "^\\d{4}$", message = "Ano do veículo deve conter 4 dígitos")
        String ano,
        String cor
) {}

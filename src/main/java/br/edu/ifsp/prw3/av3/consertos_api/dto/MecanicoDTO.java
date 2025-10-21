package br.edu.ifsp.prw3.av3.consertos_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record MecanicoDTO(
        @NotBlank
        String nome,
        @NotNull
        @PositiveOrZero
        Integer anosExperiencia
) {}

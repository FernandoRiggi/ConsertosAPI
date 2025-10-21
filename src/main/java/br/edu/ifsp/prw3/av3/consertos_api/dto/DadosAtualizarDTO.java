package br.edu.ifsp.prw3.av3.consertos_api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizarDTO(
        @NotNull
        Long id,

        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Formato de data inválido (Use dd/MM/yyyy)")
        String dataSaida,

        String mecanicoNome,

        Integer mecanicoAnosExperiencia
) {}
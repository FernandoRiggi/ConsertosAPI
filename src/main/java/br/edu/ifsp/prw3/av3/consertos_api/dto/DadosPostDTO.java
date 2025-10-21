package br.edu.ifsp.prw3.av3.consertos_api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosPostDTO(
        @NotBlank
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Formato de data inválido (Use dd/MM/yyyy)")
        String dataEntrada,
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Formato de data inválido (Use dd/MM/yyyy)")
        String dataSaida,
        @NotNull
        @Valid
        MecanicoDTO mecanico,
        @NotNull
        @Valid
        VeiculoDTO veiculo
) {}

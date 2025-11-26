package br.edu.ifsp.prw3.av3.consertos_api.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAuthDTO {
    @NotBlank
    String login,
    @NotBlank
    String senha
}{}

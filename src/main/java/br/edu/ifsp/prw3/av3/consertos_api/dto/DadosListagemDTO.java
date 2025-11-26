package br.edu.ifsp.prw3.av3.consertos_api.dto;

import br.edu.ifsp.prw3.av3.consertos_api.model.Conserto;

public record DadosListagemDTO(
        Long Id,
        String dataEntrada,
        String dataSaida,
        String mecanicoNome,
        String veiculoModelo
) {
    public DadosListagemDTO(Conserto conserto) {
        this(
                conserto.getId(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getMecanico() != null ? conserto.getMecanico().getNome() : null,
                conserto.getVeiculo() != null ? conserto.getVeiculo().getModelo() : null
        );
    }
}

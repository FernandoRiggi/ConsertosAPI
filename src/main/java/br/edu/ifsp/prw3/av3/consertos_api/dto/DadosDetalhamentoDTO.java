package br.edu.ifsp.prw3.av3.consertos_api.dto;

import br.edu.ifsp.prw3.av3.consertos_api.model.Conserto;

public record DadosDetalhamentoDTO(
        Long id,
        String dataEntrada,
        String dataSaida,
        String mecanicoNome,
        Integer mecanicoAnosExperiencia,
        String veiculoMarca,
        String veiculoModelo,
        String veiculoAno,
        String veiculoCor
) {
    public DadosDetalhamentoDTO(Conserto conserto) {
        this(
                conserto.getId(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getMecanico() != null ? conserto.getMecanico().getNome() : null,
                conserto.getMecanico() != null ? conserto.getMecanico().getAnosExperiencia() : null,
                conserto.getVeiculo() != null ? conserto.getVeiculo().getMarca() : null,
                conserto.getVeiculo() != null ? conserto.getVeiculo().getModelo() : null,
                conserto.getVeiculo() != null ? conserto.getVeiculo().getAno() : null,
                conserto.getVeiculo() != null ? conserto.getVeiculo().getCor() : null
        );
    }
}

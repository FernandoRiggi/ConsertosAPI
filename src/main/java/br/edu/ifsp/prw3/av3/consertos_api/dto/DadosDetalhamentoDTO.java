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
){}

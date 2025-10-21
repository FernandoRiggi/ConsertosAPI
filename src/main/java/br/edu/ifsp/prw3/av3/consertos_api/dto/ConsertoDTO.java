package br.edu.ifsp.prw3.av3.consertos_api.dto;

public record ConsertoDTO(
        String dataEntrada,
        String dataSaida,
        MecanicoDTO mecanico,
        VeiculoDTO veiculo
) {}

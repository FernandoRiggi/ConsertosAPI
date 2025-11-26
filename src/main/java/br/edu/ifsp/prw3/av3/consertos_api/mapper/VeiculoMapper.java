package br.edu.ifsp.prw3.av3.consertos_api.mapper;

import br.edu.ifsp.prw3.av3.consertos_api.dto.VeiculoDTO;
import br.edu.ifsp.prw3.av3.consertos_api.model.Veiculo;

import java.util.Optional;

public interface VeiculoMapper {
    Optional<VeiculoDTO> toDadosVeiculo(Veiculo veiculo);
}

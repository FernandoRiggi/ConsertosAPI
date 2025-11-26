package br.edu.ifsp.prw3.av3.consertos_api.mapper;

import br.edu.ifsp.prw3.av3.consertos_api.dto.VeiculoDTO;
import br.edu.ifsp.prw3.av3.consertos_api.model.Veiculo;

import java.util.Objects;
import java.util.Optional;

public final class VeiculoMapperImpl implements VeiculoMapper{
    @Override
    public Optional<VeiculoDTO> toDadosVeiculo(Veiculo veiculo) {
        if (Objects.isNull(veiculo)) {
            return Optional.empty();
        }

        return Optional.of(new VeiculoDTO(veiculo.getMarca(), veiculo.getModelo(), veiculo.getCor(), veiculo.getAno()));
    }
}

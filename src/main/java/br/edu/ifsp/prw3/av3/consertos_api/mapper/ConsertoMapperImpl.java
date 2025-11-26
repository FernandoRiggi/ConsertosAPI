package br.edu.ifsp.prw3.av3.consertos_api.mapper;

import br.edu.ifsp.prw3.av3.consertos_api.dto.DadosDetalhamentoDTO;
import br.edu.ifsp.prw3.av3.consertos_api.dto.DadosPostDTO;
import br.edu.ifsp.prw3.av3.consertos_api.model.Conserto;

import java.util.Objects;
import java.util.Optional;

public class ConsertoMapperImpl implements ConsertoMapper{

    private final MecanicoMapper mecanicoMapper = new MecanicoMapperImpl();
    private final VeiculoMapper veiculoMapper = new VeiculoMapperImpl();

    @Override
    public Optional<DadosPostDTO> toDadosConserto(Conserto conserto) {
        if (Objects.isNull(conserto)) {
            return Optional.empty();
        }

        return Optional.of(new DadosPostDTO(
                conserto.getDataEntrada().toString(),
                conserto.getDataSaida().toString(),
                mecanicoMapper.toDadosMecanico(conserto.getMecanico()).get(),
                veiculoMapper.toDadosVeiculo(conserto.getVeiculo()).get()
        ));
    }

    @Override
    public Optional<DadosDetalhamentoDTO> toDadosResumoConserto(Conserto conserto) {
        if (Objects.isNull(conserto)) {
            return Optional.empty();
        }

        return Optional.of(new DadosDetalhamentoDTO(
                conserto.getId(),
                conserto.getDataEntrada().toString(),
                conserto.getDataSaida().toString(),
                conserto.getMecanico().getNome(),
                conserto.getMecanico().getAnosExperiencia(),
                conserto.getVeiculo().getAno(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo(),
                conserto.getVeiculo().getCor()

        ));
    }
}

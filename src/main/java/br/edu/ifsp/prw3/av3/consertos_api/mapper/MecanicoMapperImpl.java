package br.edu.ifsp.prw3.av3.consertos_api.mapper;

import br.edu.ifsp.prw3.av3.consertos_api.dto.MecanicoDTO;
import br.edu.ifsp.prw3.av3.consertos_api.model.Mecanico;

import java.util.Objects;
import java.util.Optional;

public class MecanicoMapperImpl implements MecanicoMapper{
    @Override
    public Optional<MecanicoDTO> toDadosMecanico(Mecanico mecanico) {
        if (Objects.isNull(mecanico)) {
            return Optional.empty();
        }

        return Optional.of(new MecanicoDTO(mecanico.getNome(), mecanico.getAnosExperiencia()));
    }
}

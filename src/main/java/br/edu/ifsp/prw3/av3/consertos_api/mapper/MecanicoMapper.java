package br.edu.ifsp.prw3.av3.consertos_api.mapper;

import br.edu.ifsp.prw3.av3.consertos_api.dto.MecanicoDTO;
import br.edu.ifsp.prw3.av3.consertos_api.model.Mecanico;

import java.util.Optional;

public interface MecanicoMapper {
    Optional<MecanicoDTO> toDadosMecanico(Mecanico mecanico);
}

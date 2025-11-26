package br.edu.ifsp.prw3.av3.consertos_api.mapper;

import br.edu.ifsp.prw3.av3.consertos_api.dto.DadosDetalhamentoDTO;
import br.edu.ifsp.prw3.av3.consertos_api.dto.DadosPostDTO;
import br.edu.ifsp.prw3.av3.consertos_api.model.Conserto;

import java.util.Optional;

public interface ConsertoMapper {
    Optional<DadosPostDTO> toDadosConserto(Conserto conserto);
    Optional<DadosDetalhamentoDTO> toDadosResumoConserto(Conserto conserto);
}

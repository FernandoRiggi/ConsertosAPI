package br.edu.ifsp.prw3.av3.consertos_api.controller;

import br.edu.ifsp.prw3.av3.consertos_api.dto.DadosAtualizarDTO;
import br.edu.ifsp.prw3.av3.consertos_api.dto.DadosDetalhamentoDTO;
import br.edu.ifsp.prw3.av3.consertos_api.dto.DadosListagemDTO;
import br.edu.ifsp.prw3.av3.consertos_api.dto.DadosPostDTO;
import br.edu.ifsp.prw3.av3.consertos_api.model.Conserto;
import br.edu.ifsp.prw3.av3.consertos_api.model.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoDTO> cadastrar(@RequestBody @Valid DadosPostDTO dados,
                                                          UriComponentsBuilder uriBuilder) {
        var conserto = new Conserto(dados);
        repository.save(conserto);

        var uri = uriBuilder.path("/consertos/{id}")
                .buildAndExpand(conserto.getId())
                .toUri();

        var dto = new DadosDetalhamentoDTO(
                conserto.getId(),
                conserto.getDataEntrada().toString(),
                conserto.getDataSaida().toString(),
                conserto.getMecanico().getNome(),
                conserto.getMecanico().getAnosExperiencia(),
                conserto.getVeiculo().getAno(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo(),
                conserto.getVeiculo().getCor()
        );

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoDTO>> listarTodos(Pageable paginacao) {
        var page = repository.findAll(paginacao)
                .map(conserto -> new DadosDetalhamentoDTO(
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
        return ResponseEntity.ok(page);
    }

    @GetMapping("/parcial")
    public ResponseEntity<Page<DadosListagemDTO>> listarParcial(Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao)
                .map(conserto -> new DadosListagemDTO(
                        conserto.getId(),
                        conserto.getDataEntrada().toString(),
                        conserto.getDataSaida().toString(),
                        conserto.getMecanico().getNome(),
                        conserto.getVeiculo().getModelo()
                ));
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoDTO> detalhar(@PathVariable Long id) {

        Optional<Conserto> optionalConserto = repository.findById(id);

        if (optionalConserto.isPresent()) {
            Conserto conserto = optionalConserto.get();

            var dto = new DadosDetalhamentoDTO(
                    conserto.getId(),
                    conserto.getDataEntrada().toString(),
                    conserto.getDataSaida().toString(),
                    conserto.getMecanico().getNome(),
                    conserto.getMecanico().getAnosExperiencia(),
                    conserto.getVeiculo().getAno(),
                    conserto.getVeiculo().getMarca(),
                    conserto.getVeiculo().getModelo(),
                    conserto.getVeiculo().getCor()
            );

            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoDTO> atualizar(@RequestBody @Valid DadosAtualizarDTO dados) {

        Conserto conserto = repository.getReferenceById(dados.id());

        conserto.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoDTO(
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

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Conserto conserto = repository.getReferenceById(id);

        conserto.excluir();

        return ResponseEntity.noContent().build();
    }
}

package br.edu.ifsp.prw3.av3.consertos_api.controller;

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
import java.util.List;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosPostDTO dados) {
        var conserto = new Conserto(dados);

        repository.save(conserto);

        System.out.println("Dados recebidos no cadastro: " + dados);
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoDTO>> listarTodos(Pageable paginacao) {
        var page = repository.findAll(paginacao)
                .map(DadosDetalhamentoDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/parcial")
    public ResponseEntity<List<DadosListagemDTO>> listarParcial() {
        List<Conserto> consertos = repository.findAll();
        List<DadosListagemDTO> dtos = consertos.stream()
                .map(DadosListagemDTO::new)
                .toList();
        return ResponseEntity.ok(dtos);
    }
}

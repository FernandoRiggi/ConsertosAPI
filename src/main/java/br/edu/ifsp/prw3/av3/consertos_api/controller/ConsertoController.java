package br.edu.ifsp.prw3.av3.consertos_api.controller;

import br.edu.ifsp.prw3.av3.consertos_api.dto.ConsertoDTO;
import br.edu.ifsp.prw3.av3.consertos_api.model.Conserto;
import br.edu.ifsp.prw3.av3.consertos_api.model.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid ConsertoDTO dados) {
        var conserto = new Conserto(dados);

        repository.save(conserto);

        System.out.println("Dados recebidos no cadastro: " + dados);
    }
}

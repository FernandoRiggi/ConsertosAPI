package br.edu.ifsp.prw3.av3.consertos_api.controller;

import br.edu.ifsp.prw3.av3.consertos_api.dto.DadosAuthDTO;
import br.edu.ifsp.prw3.av3.consertos_api.dto.DadosRespostaLogin;
import br.edu.ifsp.prw3.av3.consertos_api.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ifsp.prw3.av3.consertos_api.security.JWTService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final JWTService tokenService;

    public AutenticacaoController(AuthenticationManager authenticationManager, JWTService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<DadosRespostaLogin> login(@RequestBody @Valid DadosAuthDTO dados) {
        final UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        final Authentication authenticate = authenticationManager.authenticate(token);
        final String authToken = tokenService.gerarToken((Usuario) authenticate.getPrincipal());

        return ResponseEntity.ok(new DadosRespostaLogin(authToken));
    }
}
package br.edu.ifsp.prw3.av3.consertos_api.controller;

import br.edu.ifsp.prw3.av3.consertos_api.
import br.edu.ifsp.prw3.av3.consertos_api.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import security.JWTService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
    private final AuthenticationManager authenticationManager;
    private final JWTService tokenService;

    public AutenticacaoController(AuthenticationManager authenticationManager, JWTService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<DadosRespostaLogin> login(@RequestBody @Valid DadosAuth dados) {
        final UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        final Authentication authenticate = authenticationManager.authenticate(token);
        final String authToken = tokenService.gerarToken((Usuario) authenticate.getPrincipal());

        return ResponseEntity.ok(new DadosRespostaLogin(authToken));
    }
}
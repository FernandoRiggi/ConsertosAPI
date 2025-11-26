package br.edu.ifsp.prw3.av3.consertos_api.security;

import br.edu.ifsp.prw3.av3.consertos_api.model.Usuario;
import br.edu.ifsp.prw3.av3.consertos_api.model.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class SegurancaFiltro extends OncePerRequestFilter {
    private final JWTService tokenService;
    private final UsuarioRepository usuarioRepository;

    public SegurancaFiltro(JWTService tokenService, UsuarioRepository usuarioRepository) {
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            final String token = authHeader.replace("Bearer ", "");
            final String subject = tokenService.getSubject(token);
            final Optional<Usuario> usuarioOpt = usuarioRepository.findByLogin(subject);
            if (usuarioOpt.isPresent() && SecurityContextHolder.getContext().getAuthentication() == null) {
                final Usuario usuario = usuarioOpt.get();
                final Authentication auth = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        filterChain.doFilter(request, response);
    }
}

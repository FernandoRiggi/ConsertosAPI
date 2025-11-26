package br.edu.ifsp.prw3.av3.consertos_api.model;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByName(String nome);
}

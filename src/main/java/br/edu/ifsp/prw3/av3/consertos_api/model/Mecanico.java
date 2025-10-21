package br.edu.ifsp.prw3.av3.consertos_api.model;

import br.edu.ifsp.prw3.av3.consertos_api.dto.MecanicoDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private Integer anosExperiencia;

    public Mecanico(MecanicoDTO dto) {
        this.nome = dto.nome();
        this.anosExperiencia = dto.anosExperiencia();
    }
}

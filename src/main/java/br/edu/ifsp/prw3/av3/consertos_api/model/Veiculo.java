package br.edu.ifsp.prw3.av3.consertos_api.model;

import br.edu.ifsp.prw3.av3.consertos_api.dto.VeiculoDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    private String marca;
    private String modelo;
    private String ano;

    public Veiculo(VeiculoDTO dto) {
        this.marca = dto.marca();
        this.modelo = dto.modelo();
        this.ano = dto.ano();
    }
}


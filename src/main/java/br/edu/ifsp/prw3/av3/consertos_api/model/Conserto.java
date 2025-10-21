package br.edu.ifsp.prw3.av3.consertos_api.model;

import br.edu.ifsp.prw3.av3.consertos_api.dto.ConsertoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Conserto")
@Table(name = "conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataEntrada;
    private String dataSaida;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "nome", column = @Column(name = "mecanico_nome")),
            @AttributeOverride(name = "anosExperiencia", column = @Column(name = "mecanico_anos_experiencia"))
    })
    private Mecanico mecanico;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "marca", column = @Column(name = "veiculo_marca")),
            @AttributeOverride(name = "modelo", column = @Column(name = "veiculo_modelo")),
            @AttributeOverride(name = "ano", column = @Column(name = "veiculo_ano"))
    })
    private Veiculo veiculo;

    public Conserto(ConsertoDTO dto) {
        this.dataEntrada = dto.dataEntrada();
        this.dataSaida = dto.dataSaida();
        this.mecanico = new Mecanico(dto.mecanico());
        this.veiculo = new Veiculo((dto.veiculo()));
    }
}

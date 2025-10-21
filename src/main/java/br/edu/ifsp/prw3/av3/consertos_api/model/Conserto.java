package br.edu.ifsp.prw3.av3.consertos_api.model;

import br.edu.ifsp.prw3.av3.consertos_api.dto.DadosAtualizarDTO;
import br.edu.ifsp.prw3.av3.consertos_api.dto.DadosPostDTO;
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
            @AttributeOverride(name = "ano", column = @Column(name = "veiculo_ano")),
            @AttributeOverride(name = "cor", column = @Column(name = "veiculo_cor"))
    })
    private Veiculo veiculo;
    private Boolean ativo;

    public Conserto(DadosPostDTO dto) {
        this.ativo = true;
        this.dataEntrada = dto.dataEntrada();
        this.dataSaida = dto.dataSaida();
        this.mecanico = new Mecanico(dto.mecanico());
        this.veiculo = new Veiculo((dto.veiculo()));
    }

    public void excluir() {
        this.ativo = false;
    }

    public void atualizarInformacoes(DadosAtualizarDTO dados) {
        if (dados.dataSaida() != null) {
            this.dataSaida = dados.dataSaida();
        }

        if (this.mecanico != null) {
            if (dados.mecanicoNome() != null || dados.mecanicoAnosExperiencia() != null) {
                this.mecanico.atualizarInformacoesParcial(dados.mecanicoNome(), dados.mecanicoAnosExperiencia());
            }
        }
    }
}

package com.rlti.autoescola.frota.manutencao.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.frota.manutencao.application.api.ManutencaoRequest;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idManutencao;
    private LocalDate dataManutencao;
    private BigDecimal valorManutencao;
    @Enumerated(EnumType.STRING)
    private TipoManutencao tipoManutencao;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    @JsonIgnore
    private Veiculo veiculo;

    public Manutencao(Veiculo veiculo, ManutencaoRequest request) {
        this.dataManutencao = request.getDataManutencao();
        this.valorManutencao = request.getValorManutencao();
        this.tipoManutencao = request.getTipoManutencao();
        this.descricao = request.getDescricao();
        this.veiculo = veiculo;
    }

    public void altera(ManutencaoRequest request) {
        this.dataManutencao = request.getDataManutencao();
        this.valorManutencao = request.getValorManutencao();
        this.tipoManutencao = request.getTipoManutencao();
        this.descricao = request.getDescricao();
    }


}

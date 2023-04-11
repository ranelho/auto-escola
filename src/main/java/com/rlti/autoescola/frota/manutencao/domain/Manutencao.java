package com.rlti.autoescola.frota.manutencao.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.frota.manutencao.domain.TipoManutencao;
import com.rlti.autoescola.frota.manutencao.application.api.ManutencaoRequest;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idManutencao;
    private LocalDate dataManutencao;
    private BigDecimal valorManutencao;
    @Enumerated(EnumType.STRING)
    private TipoManutencao tipoManutencao;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    @JsonIgnore
    private Veiculo veiculo;

    public Manutencao(Veiculo veiculo, ManutencaoRequest request) {
        this.dataManutencao = request.getDataManutencao();
        this.valorManutencao = request.getValorManutencao();
        this.tipoManutencao = request.getTipoManutencao();
        this.veiculo = veiculo;
    }

    public void altera(ManutencaoRequest request) {
        this.dataManutencao = request.getDataManutencao();
        this.valorManutencao = request.getValorManutencao();
        this.tipoManutencao = request.getTipoManutencao();
    }


}

package com.rlti.autoescola.servico.domain;

import com.rlti.autoescola.matricula.domain.Status;
import com.rlti.autoescola.servico.application.api.ServicoUpdateRequest;
import com.rlti.autoescola.servico.application.api.ServicoRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idServico;
    @Column(unique = true, updatable = false)
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private BigDecimal valorServico;
    @Enumerated(EnumType.STRING)
    private Status status = Status.ATIVO;
    private Integer quantidadeHorasAula;

    public Servico(ServicoRequest request) {
        this.categoria = request.getCategoria();
        this.valorServico = request.getValorServico();
        this.quantidadeHorasAula = request.getQuantidadeHorasAula();
    }

    public void altera(ServicoUpdateRequest alteracaoRequest) {
        this.valorServico = alteracaoRequest.getValorServico();
        this.quantidadeHorasAula = alteracaoRequest.getQuantidadeHorasAula();
    }

    public void alteraStatus() {
        this.status = Status.INATIVO;
    }
}
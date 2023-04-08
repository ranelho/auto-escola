package com.rlti.autoescola.orcamento.application.api;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.servico.domain.Servico;
import lombok.Value;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import java.time.LocalDate;

@Value
public class OrcamentoRequest {
    private Cliente cliente;
    private Servico servico;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;
    protected LocalDate dataOrcamento;
    private Double valorEntrada;
    private int desconto;
    private int quantidadeParcelas;
    private String observacao;
    private LocalDate validade;
}

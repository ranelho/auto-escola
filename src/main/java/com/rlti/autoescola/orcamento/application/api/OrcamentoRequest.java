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
    //Cliente cliente;
    //Servico servico;

    @Enumerated(EnumType.STRING)
    TipoPagamento tipoPagamento;
    LocalDate dataOrcamento;
    Double valorEntrada;
    int desconto;
    int quantidadeParcelas;
    String observacao;
    LocalDate validade;
}

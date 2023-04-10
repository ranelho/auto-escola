package com.rlti.autoescola.orcamento.application.api;

import com.rlti.autoescola.matricula.domain.TipoPagamento;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class OrcamentoRequest {
    UUID idCliente;
    UUID idServico;
    TipoPagamento tipoPagamento;
    LocalDate dataOrcamento;
    Double valorEntrada;
    int desconto;
    int quantidadeParcelas;
    String observacao;
    LocalDate validade;
}

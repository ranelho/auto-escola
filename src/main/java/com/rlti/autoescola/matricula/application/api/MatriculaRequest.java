package com.rlti.autoescola.matricula.application.api;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.matricula.domain.TipoServico;
import com.rlti.autoescola.servico.domain.Servico;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Value
public class MatriculaRequest {
    UUID idCliente;
    UUID idServico;
    TipoPagamento tipoPagamento;
    Double valorEntrada;
    int desconto;
    int quantidadeParcelas;
    String observacao;
    TipoServico tipoServico;
}

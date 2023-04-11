package com.rlti.autoescola.matricula.application.api;

import com.rlti.autoescola.matricula.domain.TipoPagamento;
//import com.rlti.autoescola.matricula.domain.TipoServico;
import com.rlti.autoescola.matricula.domain.TipoServico;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class MatriculaRequest {
    UUID idCliente;
    UUID idServico;
    TipoPagamento tipoPagamento;
    LocalDate dataOrcamento;
    Double valorEntrada;
    int desconto;
    int quantidadeParcelas;
    String observacao;
    TipoServico tipoServico;
}

package com.rlti.autoescola.matricula.application.api;

import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.matricula.domain.TipoServico;
import lombok.Value;
import javax.validation.constraints.NotBlank;
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
    @NotBlank
    TipoServico tipoServico;
}

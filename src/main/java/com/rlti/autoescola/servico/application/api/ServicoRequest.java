package com.rlti.autoescola.servico.application.api;

import com.rlti.autoescola.servico.domain.Categoria;
import lombok.Value;

@Value
public class ServicoRequest {
    Categoria categoria;
    double valorServico;
}

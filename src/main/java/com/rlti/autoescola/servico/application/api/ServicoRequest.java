package com.rlti.autoescola.servico.application.api;

import com.rlti.autoescola.servico.domain.Categoria;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class ServicoRequest {
    Categoria categoria;
    BigDecimal valorServico;
}
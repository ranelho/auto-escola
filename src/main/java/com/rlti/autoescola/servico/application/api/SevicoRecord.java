package com.rlti.autoescola.servico.application.api;

import com.rlti.autoescola.servico.domain.Categoria;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record SevicoRecord (
        @NotNull Categoria categoria,
        @NotNull BigDecimal valorServico,
        @NotNull Integer quantidadeHorasAula
) { }
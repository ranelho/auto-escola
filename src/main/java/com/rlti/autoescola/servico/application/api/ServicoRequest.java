package com.rlti.autoescola.servico.application.api;

import com.rlti.autoescola.servico.domain.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class ServicoRequest {
    @NotNull
    Categoria categoria;
    @NotNull
    BigDecimal valorServico;
    @NotBlank
    Integer quantidadeHorasAula;
}
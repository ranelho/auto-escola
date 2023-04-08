package com.rlti.autoescola.servico.application.api;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ServicoUpdateRequest {
    @NotNull
    BigDecimal valorServico;
}
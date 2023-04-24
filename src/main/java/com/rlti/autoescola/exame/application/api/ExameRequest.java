package com.rlti.autoescola.exame.application.api;

import com.rlti.autoescola.exame.domain.Resultado;
import com.rlti.autoescola.exame.domain.TipoExame;
import lombok.Value;

import java.time.LocalDate;

@Value
public class ExameRequest {
    TipoExame tipoExame;
    LocalDate dataExame;
    Resultado resultado;
    String observacao;
}

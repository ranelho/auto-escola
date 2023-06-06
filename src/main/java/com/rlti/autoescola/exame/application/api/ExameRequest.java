package com.rlti.autoescola.exame.application.api;

import com.rlti.autoescola.exame.domain.Resultado;
import com.rlti.autoescola.exame.domain.TipoExame;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExameRequest {
    TipoExame tipoExame;
    LocalDate dataExame;
    Resultado resultado;
    String observacao;
}

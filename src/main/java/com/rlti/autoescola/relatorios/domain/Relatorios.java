package com.rlti.autoescola.relatorios.domain;

import com.rlti.autoescola.relatorios.application.api.ClienteResponseRelatorio;
import com.rlti.autoescola.relatorios.application.api.MatriculaResponseRelatorio;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Relatorios {
    LocalDate data;
    List<ClienteResponseRelatorio> clientes;
    List<MatriculaResponseRelatorio> matriculas;
}

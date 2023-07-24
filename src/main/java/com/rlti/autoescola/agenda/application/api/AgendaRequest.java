package com.rlti.autoescola.agenda.application.api;

import com.rlti.autoescola.agenda.domain.HorarioAula;
import com.rlti.autoescola.agenda.domain.TipoAula;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class AgendaRequest {
    @NotNull(message = "O campo não pode ser null")
    LocalDate data;
    @NotNull(message = "O campo não pode ser null")
    HorarioAula horarioAula;
    @NotNull(message = "O campo não pode ser null")
    TipoAula tipoAula;
    @NotNull(message = "O instrutor não pode ser null")
    UUID idInstrutor;
    @NotNull(message = "A matricula não pode ser null")
    UUID idMatricula;
    @NotNull(message = "A placa não pode ser null")
    String placa;
}

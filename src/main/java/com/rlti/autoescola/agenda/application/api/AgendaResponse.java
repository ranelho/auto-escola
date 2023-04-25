package com.rlti.autoescola.agenda.application.api;

import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.agenda.domain.HorarioAula;
import com.rlti.autoescola.agenda.domain.TipoAula;
import com.rlti.autoescola.instrutor.domain.Instrutor;
import com.rlti.autoescola.matricula.domain.Matricula;
import lombok.Value;

import java.time.LocalDate;

@Value
public class AgendaResponse {
    LocalDate data;
    HorarioAula horarioAula;
    TipoAula tipoAula;

    public AgendaResponse(Agenda agenda) {
        this.data = agenda.getData();
        this.horarioAula = agenda.getHorarioAula();
        this.tipoAula = agenda.getTipoAula();
    }
}
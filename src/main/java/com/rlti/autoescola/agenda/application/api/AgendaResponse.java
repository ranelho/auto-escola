package com.rlti.autoescola.agenda.application.api;

import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.agenda.domain.HorarioAula;
import com.rlti.autoescola.agenda.domain.TipoAula;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Value
public class AgendaResponse {
    Long idAgenda;
    LocalDate data;
    HorarioAula horarioAula;
    BigDecimal horaAulaRealizada;
    TipoAula tipoAula;
    UUID idInstrutor;
    UUID idMatricula;
    String placa;

    public AgendaResponse(Agenda agenda) {
        this.idAgenda = agenda.getIdAgenda();
        this.idInstrutor = agenda.getInstrutor().getIdInstrutor();
        this.idMatricula = agenda.getMatricula().getIdMatricula();
        this.placa = agenda.getVeiculo().getPlaca();
        this.data = agenda.getData();
        this.horarioAula = agenda.getHorarioAula();
        this.horaAulaRealizada = agenda.getHoraAulaRealizada();
        this.tipoAula = agenda.getTipoAula();
    }
}
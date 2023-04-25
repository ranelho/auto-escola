package com.rlti.autoescola.agenda.application.api;

import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.agenda.domain.TipoAula;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Value
public class AgendaResponse {
    Long idAgenda;
    LocalDate data;
    LocalTime horario;
    TipoAula tipoAula;
    UUID idInstrutor;
    UUID idMatricula;
    UUID idVeiculo;

    public AgendaResponse(Agenda agenda) {
        this.idAgenda = agenda.getIdAgenda();
        this.data = agenda.getData();
        this.horario = agenda.getHorario();
        this.tipoAula = agenda.getTipoAula();
        this.idInstrutor = agenda.getInstrutor().getIdInstrutor();
        this.idMatricula = agenda.getMatricula().getIdMatricula();
        this.idVeiculo = agenda.getVeiculo().getIdVeiculo();
    }


}
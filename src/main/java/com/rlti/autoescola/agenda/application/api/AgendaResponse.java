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
    UUID idMatricula;
    String fullName;//matricula
    String cpf;//matricula
    String observacao;//matricula
    String status;//matricula
    String placa;//veiculo
    String marca;//veiculo
    TipoAula tipoAula;//agenda
    LocalDate data;//agenda
    LocalTime horario;//agenda

    public AgendaResponse(Agenda agenda){
        this.idAgenda = agenda.getIdAgenda();
        this.idMatricula = agenda.getMatricula().getIdMatricula();
        //this.fullName = agenda.getCliente().getFullName();
        //this.cpf = agenda.getCliente().getCpf();

    }
}
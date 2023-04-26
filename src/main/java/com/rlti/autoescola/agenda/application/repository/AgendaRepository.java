package com.rlti.autoescola.agenda.application.repository;

import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.instrutor.domain.Instrutor;

import java.util.List;
import java.util.UUID;

public interface AgendaRepository {
    Agenda save(Agenda agenda);
    List<Agenda> buscaAgendamentos();
    Agenda getByIdAgenda(Long idAgenda);
    List<Agenda> getAgendaByIdInstrutor(Instrutor instrutor);

}
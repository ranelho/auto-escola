package com.rlti.autoescola.agenda.application.repository;

import com.rlti.autoescola.agenda.domain.Agenda;
import java.util.List;

public interface AgendaRepository {
    Agenda save(Agenda agenda);
    Agenda getByIdAgenda(Long idAgenda);
    List<Agenda> buscaAgendamentos();
}
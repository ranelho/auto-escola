package com.rlti.autoescola.agenda.application.repository;


import com.rlti.autoescola.agenda.domain.Agenda;

public interface AgendaRepository {
    Agenda save(Agenda agenda);
    Agenda findById(Long idAgenda);
}
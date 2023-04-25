package com.rlti.autoescola.agenda.application.repository;


import com.rlti.autoescola.agenda.application.api.AgendaResponse;
import com.rlti.autoescola.agenda.domain.Agenda;

import java.util.UUID;

public interface AgendaRepository {
    Agenda save(Agenda agenda);
}
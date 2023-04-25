package com.rlti.autoescola.agenda.application.service;

import com.rlti.autoescola.agenda.application.api.AgendaIdResponse;
import com.rlti.autoescola.agenda.application.api.AgendaRequest;
import com.rlti.autoescola.agenda.application.api.AgendaResponse;

public interface AgendaService {
    AgendaIdResponse post(AgendaRequest agendaRequest);
    AgendaResponse findById(Long idAgenda);
}

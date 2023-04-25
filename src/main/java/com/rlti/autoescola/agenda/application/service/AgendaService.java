package com.rlti.autoescola.agenda.application.service;

import com.rlti.autoescola.agenda.application.api.AgendaIdResponse;
import com.rlti.autoescola.agenda.application.api.AgendaRequest;

public interface AgendaService {
    AgendaIdResponse post(AgendaRequest agendaRequest);
}

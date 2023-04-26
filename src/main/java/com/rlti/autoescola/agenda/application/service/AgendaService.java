package com.rlti.autoescola.agenda.application.service;

import com.rlti.autoescola.agenda.application.api.AgendaIdResponse;
import com.rlti.autoescola.agenda.application.api.AgendaListResponse;
import com.rlti.autoescola.agenda.application.api.AgendaRequest;
import com.rlti.autoescola.agenda.application.api.AgendaResponse;

import java.util.List;

public interface AgendaService {
    AgendaIdResponse post(AgendaRequest agendaRequest);
    AgendaResponse getByIdAgenda(Long idAgenda);
    List<AgendaListResponse> buscaAgendamentos();
}

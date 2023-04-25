package com.rlti.autoescola.agenda.application.service;

import com.rlti.autoescola.agenda.application.api.AgendaIdResponse;
import com.rlti.autoescola.agenda.application.api.AgendaRequest;

import java.util.UUID;

public interface AgendaService {
    AgendaIdResponse post(UUID idInstrutor, UUID idMatricula, String placa, AgendaRequest agendaRequest);
}

package com.rlti.autoescola.agenda.application.api;

import com.rlti.autoescola.agenda.application.service.AgendaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@Log4j2
public class AgendaRestController implements AgendaAPI {
    private final AgendaService agendaService;

    @Override
    public AgendaIdResponse post(AgendaRequest agendaRequest) {
        log.info("[inicia] - AgendaRestController - post");
        AgendaIdResponse agendaResponse = agendaService.post(agendaRequest);
        log.info("[finaliza] - AgendaRestController - post");
        return agendaResponse;
    }

    @Override
    public AgendaResponse findById(Long idAgenda) {
        log.info("[inicia] - AgendaIdResponse - getAgenda");
        AgendaResponse buscaAgenda = agendaService.findById(idAgenda);
        log.info("[finaliza] - AgendaIdResponse - getAgenda");
        return buscaAgenda;
    }
}

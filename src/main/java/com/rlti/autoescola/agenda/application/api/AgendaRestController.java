package com.rlti.autoescola.agenda.application.api;

import com.rlti.autoescola.agenda.application.service.AgendaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
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
    public List<AgendaListResponse> getAll() {
        log.info("[inicia] AgendaRestController - findByIdMatricula");
        List<AgendaListResponse> agendas = agendaService.buscaAgendamentos();
        log.info("[inicia] AgendaRestController - findByIdMatricula");
        return agendas;
    }

    @Override
    public AgendaResponse getByIdAgenda(Long idAgenda) {
        log.info("[inicia] - AgendaRestController - findByIdAgenda");
        AgendaResponse buscaAgenda = agendaService.getByIdAgenda(idAgenda);
        log.info("[finaliza] - AgendaRestController - findByIdAgenda");
        return buscaAgenda;
    }

    @Override
    public List<AgendaListResponse> getByIdInstrutor(UUID idInstrutor) {
        log.info("[inicia] - AgendaRestController - getByIdInstrutor");
        List<AgendaListResponse> buscaAgendaInstrutor = agendaService.getByIdInstrutor(idInstrutor);
        log.info("[finaliza] - AgendaRestController - getByIdInstrutor");
        return buscaAgendaInstrutor;
    }

    @Override
    public List<AgendaListResponse> getByIdMatricula(UUID idMatricula) {
        log.info("[inicia] - AgendaRestController - getByIdMatricula");
        List<AgendaListResponse> buscaAgendaMatricula = agendaService.getByIdMatricula(idMatricula);
        log.info("[finaliza] - AgendaRestController - getByIdMatricula");
        return buscaAgendaMatricula;
    }
}

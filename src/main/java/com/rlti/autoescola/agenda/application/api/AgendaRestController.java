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
    public AgendaIdResponse saveLaudo(AgendaRequest agendaRequest) {
        log.info("[inicia] - AgendaRestController - post");
        AgendaIdResponse agendaResponse = agendaService.post(agendaRequest);
        log.info("[finaliza] - AgendaRestController - post");
        return agendaResponse;
    }

    @Override
    public List<AgendaListResponse> getAll() {
        log.info("[inicia] AgendaRestController - getAll");
        List<AgendaListResponse> agendas = agendaService.buscaAgendamentos();
        log.info("[inicia] AgendaRestController - getAll");
        return agendas;
    }

    @Override
    public AgendaResponse getOneAgenda(Long idAgenda) {
        log.info("[inicia] - AgendaRestController - getOneAgenda");
        AgendaResponse buscaAgenda = agendaService.getByIdAgenda(idAgenda);
        log.info("[finaliza] - AgendaRestController - getOneAgenda");
        return buscaAgenda;
    }

    @Override
    public List<AgendaListResponse> getAllAgendaByInstrutor(UUID idInstrutor) {
        log.info("[inicia] - AgendaRestController - getAllAgendaByInstrutor");
        List<AgendaListResponse> buscaAgendaInstrutor = agendaService.getByIdInstrutor(idInstrutor);
        log.info("[finaliza] - AgendaRestController - getAllAgendaByInstrutor");
        return buscaAgendaInstrutor;
    }

    @Override
    public List<AgendaListResponse> getAllAgendaByMatricula(UUID idMatricula) {
        log.info("[inicia] - AgendaRestController - getAllAgendaByMatricula");
        List<AgendaListResponse> buscaAgendaMatricula = agendaService.getByIdMatricula(idMatricula);
        log.info("[finaliza] - AgendaRestController - getAllAgendaByMatricula");
        return buscaAgendaMatricula;
    }

    @Override
    public List<AgendaListResponse> getAllAgendaByVeiculo(String placa) {
        log.info("[inicia] - AgendaRestController - getAllAgendaByVeiculo");
        List<AgendaListResponse> buscaAgendaVeiculo = agendaService.getByPlaca(placa);
        log.info("[finaliza] - AgendaRestController - getAllAgendaByVeiculo");
        return buscaAgendaVeiculo;
    }
}

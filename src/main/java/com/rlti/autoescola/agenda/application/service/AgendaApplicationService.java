package com.rlti.autoescola.agenda.application.service;

import com.rlti.autoescola.agenda.application.api.AgendaIdResponse;
import com.rlti.autoescola.agenda.application.api.AgendaListResponse;
import com.rlti.autoescola.agenda.application.api.AgendaRequest;
import com.rlti.autoescola.agenda.application.api.AgendaResponse;
import com.rlti.autoescola.agenda.application.repository.AgendaRepository;
import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.agenda.domain.ValidaAgenda;
import com.rlti.autoescola.frota.veiculo.application.repository.VeiculoRepository;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import com.rlti.autoescola.instrutor.application.repository.InstrutorRepository;
import com.rlti.autoescola.instrutor.domain.Instrutor;
import com.rlti.autoescola.matricula.application.repository.MatriculaRepository;
import com.rlti.autoescola.matricula.domain.Matricula;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class AgendaApplicationService implements AgendaService {
    private final InstrutorRepository instrutorRepository;
    private final MatriculaRepository matriculaRepository;
    private final VeiculoRepository veiculoRepository;
    private final AgendaRepository agendaRepository;

    @Override
    public AgendaIdResponse post(AgendaRequest agendaRequest) {
        log.info("[inicia] - AgendaApplicationService - post");
        Instrutor instrutor = instrutorRepository.getInstrutor(agendaRequest.getIdInstrutor());
        Matricula matricula = matriculaRepository.getOneMatricula(agendaRequest.getIdMatricula());
        Veiculo veiculo = veiculoRepository.getByPlaca(agendaRequest.getPlaca());
        ValidaAgenda.validaInstrutorServico(instrutor, matricula.getServico().getCategoria());
        //validaAgenda(agendaRequest, instrutor, matricula, veiculo);
        Agenda agenda = agendaRepository.save(new Agenda(instrutor, matricula, veiculo, agendaRequest));
        log.info("[finaliza] - AgendaApplicationService - post");
        return AgendaIdResponse.builder().idAgenda(agenda.getIdAgenda()).build();
    }

    @Override
    public List<AgendaListResponse> buscaAgendamentos() {
        log.info("[inicia] - AgendaApplicationService - buscaAgendaMatricula");
        List<Agenda> agendas = agendaRepository.buscaAgendamentos();
        log.info("[finaliza] - AgendaApplicationService - buscaAgendaMatricula");
        return AgendaListResponse.converte(agendas);
    }

    @Override
    public AgendaResponse getByIdAgenda(Long idAgenda) {
        log.info("[inicia] - AgendaApplicationService - getByIdAgenda");
        Agenda agenda = agendaRepository.getByIdAgenda(idAgenda);
        log.info("[finaliza] - AgendaApplicationService - getByIdAgenda");
        return new AgendaResponse(agenda);
    }

    public List<AgendaListResponse> getByIdInstrutor(UUID idInstrutor) {
        log.info("[inicia] - AgendaApplicationService - getByIdInstrutor");
        Instrutor instrutor = instrutorRepository.getInstrutor(idInstrutor);
        List<Agenda> agendas = agendaRepository.getAgendaByIdInstrutor(instrutor);
        log.info("[finaliza] - AgendaApplicationService - getByIdInstrutor");
        return AgendaListResponse.converte(agendas);
    }

    @Override
    public List<AgendaListResponse> getByIdMatricula(UUID idMatricula) {
        log.info("[inicia] - AgendaApplicationService - getByIdMatricula");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        List<Agenda> agendas = agendaRepository.getAgendaByIdMatricula(matricula);
        log.info("[finaliza] - AgendaApplicationService - getByIdMatricula");
        return AgendaListResponse.converte(agendas);
    }

    @Override
    public List<AgendaListResponse> getByPlaca(String placa) {
        log.info("[inicia] - AgendaApplicationService - getByPlaca");
        Veiculo veiculo = veiculoRepository.getByPlaca(placa);
        List<Agenda> agendas = agendaRepository.getAgendaByPlaca(veiculo);
        log.info("[finaliza] - AgendaApplicationService - getByPlaca");
        return AgendaListResponse.converte(agendas);
    }

    @Override
    public void deleteAgenda(Long idAgenda) {
        log.info("[inicia] AgendaApplicationService -  deleteAgenda");
        Agenda agenda = agendaRepository.getByIdAgenda(idAgenda);
        agendaRepository.deleteAgenda(agenda.getIdAgenda());
        log.info("[finaliza] AgendaApplicationService -  deleteAgenda");
    }
}
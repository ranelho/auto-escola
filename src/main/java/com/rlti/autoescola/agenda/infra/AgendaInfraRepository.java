package com.rlti.autoescola.agenda.infra;

import com.rlti.autoescola.agenda.application.repository.AgendaRepository;
import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.instrutor.domain.Instrutor;
import com.rlti.autoescola.matricula.domain.Matricula;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Log4j2
public class AgendaInfraRepository implements AgendaRepository {
    private final AgendaSpringDataJPARepository agendaSpringDataJPARepository;

   @Override
    public Agenda save(Agenda agenda) {
        log.info("[inicia] - AgendaInfraRepository - post");
        agendaSpringDataJPARepository.save(agenda);
        log.info("[finaliza] - AgendaInfraRepository - post");
        return agenda;
    }

    @Override
    public List<Agenda> buscaAgendamentos() {
        log.info("[inicia] - AgendaInfraRepository - buscaAgendamentos");
        List<Agenda> agendamentos = agendaSpringDataJPARepository.findAll();
        log.info("[finaliza] - AgendaInfraRepository - buscaAgendamentos");
        return agendamentos;
    }

    @Override
    public Agenda getByIdAgenda(Long idAgenda) {
        log.info("[inicia] - AgendaInfraRepository - getAgenda");
        Optional<Agenda> optionalAgenda = agendaSpringDataJPARepository.findByIdAgenda(idAgenda);
        Agenda agenda = optionalAgenda
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Agenda não cadastrada!"));
        log.info("[finaliza] - AgendaInfraRepository - getAgenda");
        return agenda;
    }

    @Override
    public List<Agenda> getAgendaByIdInstrutor(Instrutor instrutor) {
        log.info("[inicia] - AgendaInfraRepository - getAgenda");
        List<Agenda> agendas = agendaSpringDataJPARepository.findAgendaByInstrutor(instrutor);
        log.info("[finaliza] - AgendaInfraRepository - getAgenda");
        return agendas;
    }

    @Override
    public List<Agenda> getAgendaByIdMatricula(Matricula matricula) {
        log.info("[inicia] - AgendaInfraRepository - getAgenda");
        List<Agenda> agendas = agendaSpringDataJPARepository.findAgendaByMatricula(matricula);
        log.info("[finaliza] - AgendaInfraRepository - getAgenda");
        return agendas;
    }
}

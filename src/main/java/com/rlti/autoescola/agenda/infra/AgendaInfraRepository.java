package com.rlti.autoescola.agenda.infra;

import com.rlti.autoescola.agenda.application.repository.AgendaRepository;
import com.rlti.autoescola.agenda.domain.Agenda;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}

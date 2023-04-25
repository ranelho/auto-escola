package com.rlti.autoescola.agenda.infra;

import com.rlti.autoescola.agenda.application.api.AgendaResponse;
import com.rlti.autoescola.agenda.application.repository.AgendaRepository;
import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

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
    public Agenda findById(Long idAgenda) {
        log.info("[inicia] - AgendaInfraRepository - getAgenda");
        Optional<Agenda> optionalAgenda = agendaSpringDataJPARepository.findById(idAgenda);
        Agenda agenda = optionalAgenda
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Agenda não cadastrada!"));
        log.info("[finaliza] - AgendaInfraRepository - getAgenda");
        return agenda;
    }
}

package com.rlti.autoescola.agenda.application.service;

import com.rlti.autoescola.agenda.application.api.AgendaIdResponse;
import com.rlti.autoescola.agenda.application.api.AgendaRequest;
import com.rlti.autoescola.agenda.application.repository.AgendaRepository;
import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.frota.veiculo.application.repository.VeiculoRepository;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import com.rlti.autoescola.instrutor.application.repository.InstrutorRepository;
import com.rlti.autoescola.instrutor.domain.Instrutor;
import com.rlti.autoescola.matricula.application.repository.MatriculaRepository;
import com.rlti.autoescola.matricula.domain.Matricula;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
    public AgendaIdResponse post(UUID idInstrutor, UUID idMatricula, String placa, AgendaRequest agendaRequest) {
        log.info("[inicia] - AgendaApplicationService - post");
        Instrutor instrutor = instrutorRepository.getInstrutor(idInstrutor);
        Matricula matricula = matriculaRepository.matriculaAtravesId(idMatricula);
        Veiculo veiculo = veiculoRepository.getByPlaca(placa);
        Agenda agenda = agendaRepository.save(new Agenda(instrutor, matricula, veiculo, agendaRequest));
        log.info("[finaliza] - AgendaApplicationService - post");
        return AgendaIdResponse.builder().idAgenda(agenda.getIdAgenda()).build();
    }
}

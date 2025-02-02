package com.rlti.autoescola.agenda.infra;

import com.rlti.autoescola.agenda.application.repository.AgendaRepository;
import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.agenda.domain.HorarioAula;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.instrutor.domain.Instrutor;
import com.rlti.autoescola.matricula.domain.Matricula;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Log4j2
public class AgendaInfraRepository implements AgendaRepository {
    private final AgendaSpringDataJPARepository agendaSpringDataJPARepository;

   @Override
    public Agenda saveAgenda(Agenda agenda) {
        log.info("[inicia] - AgendaInfraRepository - saveAgenda");
        agendaSpringDataJPARepository.save(agenda);
        log.info("[finaliza] - AgendaInfraRepository - saveAgenda");
        return agenda;
    }

    @Override
    public List<Agenda> getAllAgendas() {
        log.info("[inicia] - AgendaInfraRepository - getAllAgendas");
        List<Agenda> agendamentos = agendaSpringDataJPARepository.findAll();
        log.info("[finaliza] - AgendaInfraRepository - getAllAgendas");
        return agendamentos;
    }

    @Override
    public Agenda getByIdAgenda(Long idAgenda) {
        log.info("[inicia] - AgendaInfraRepository - getAgenda");
        Optional<Agenda> optionalAgenda = agendaSpringDataJPARepository.findByIdAgenda(idAgenda);
        Agenda agenda = optionalAgenda
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Agenda não cadastrada!"));
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

    @Override
    public List<Agenda> getAgendaByPlaca(Veiculo veiculo) {
        log.info("[inicia] - AgendaInfraRepository - getAgenda");
        List<Agenda> agendas = agendaSpringDataJPARepository.findAgendaByVeiculo(veiculo);
        log.info("[finaliza] - AgendaInfraRepository - getAgenda");
        return agendas;
    }

    @Override
    public void deleteAgenda(Long idAgenda) {
        log.info("[inicia] AgendaInfraRepository - deleteAgenda");
        agendaSpringDataJPARepository.deleteById(idAgenda);
        log.info("[finaliza] AgendaInfraRepository - deleteAgenda");
    }

    @Override
    public Optional<Agenda> getDataAndHorario(LocalDate data, HorarioAula horarioAula) {
        log.info("[inicia] getDataAndHorario - deleteAgenda");
        Optional<Agenda> agenda = agendaSpringDataJPARepository.findByDataAndHorarioAula(data, horarioAula);
        log.info("[finaliza] getDataAndHorario - deleteAgenda");
        return agenda;
    }

    @Override
    public List<Agenda> getAgendasPorData(LocalDate data) {
       log.info("[inicia] getAgendasPorData - deleteAgenda");
       List<Agenda> agendas = agendaSpringDataJPARepository.findByData(data);
       log.info("[finaliza] getAgendasPorData - deleteAgenda");
       return agendas;
    }

    @Override
    public List<Agenda> getAgendasPorDataEInstrutor(LocalDate data, Instrutor instrutor) {
        log.info("[inicia] getAgendasPorDataEInstrutor - deleteAgenda");
        List<Agenda> agendas = agendaSpringDataJPARepository.findByDataAndInstrutor(data, instrutor);
        log.info("[finaliza] getAgendasPorDataEInstrutor - deleteAgenda");
        return agendas;
    }

    @Override
    public List<Agenda> getAgendasPorDataEVeiculo(LocalDate data, Veiculo veiculo) {
       log.info("[inicia] getAgendasPorDataEVeiculo - deleteAgenda");
       List<Agenda> agendas = agendaSpringDataJPARepository.findByDataAndVeiculo(data, veiculo);
       log.info("[finaliza] getAgendasPorDataEVeiculo - deleteAgenda");
       return agendas;
    }
}
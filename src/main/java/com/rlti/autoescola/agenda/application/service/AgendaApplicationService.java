package com.rlti.autoescola.agenda.application.service;

import com.rlti.autoescola.agenda.annotation.constraints.ValidaAgenda;
import com.rlti.autoescola.agenda.application.api.AgendaIdResponse;
import com.rlti.autoescola.agenda.application.api.AgendaListResponse;
import com.rlti.autoescola.agenda.application.api.AgendaRequest;
import com.rlti.autoescola.agenda.application.api.AgendaResponse;
import com.rlti.autoescola.agenda.application.repository.AgendaRepository;
import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.agenda.domain.HorarioAula;
import com.rlti.autoescola.frota.veiculo.application.repository.VeiculoRepository;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import com.rlti.autoescola.instrutor.application.repository.InstrutorRepository;
import com.rlti.autoescola.instrutor.domain.Instrutor;
import com.rlti.autoescola.matricula.application.repository.MatriculaRepository;
import com.rlti.autoescola.matricula.domain.Matricula;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
    public AgendaIdResponse saveAgenda(AgendaRequest request) {
        log.info("[inicia] - AgendaApplicationService - saveAgenda");
        Instrutor instrutor = instrutorRepository.getInstrutor(request.getIdInstrutor());
        Matricula matricula = matriculaRepository.getOneMatricula(request.getIdMatricula());
        Veiculo veiculo = veiculoRepository.getByPlaca(request.getPlaca());
        List<Agenda> agendasPorData = agendaRepository.getAgendasPorData(request.getData());
        ValidaAgenda.isValid(instrutor, matricula, veiculo, request, agendasPorData);
        Agenda agenda = agendaRepository.saveAgenda(new Agenda(instrutor, matricula, veiculo, request));
        log.info("[finaliza] - AgendaApplicationService - saveAgenda");
        return AgendaIdResponse.builder().idAgenda(agenda.getIdAgenda()).build();
    }

    @Override
    public List<AgendaListResponse> buscaAgendamentos() {
        log.info("[inicia] - AgendaApplicationService - buscaAgendaMatricula");
        List<Agenda> agendas = agendaRepository.getAllAgendas();
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

    public List<HorarioAula> getHorariosDisponiveis(LocalDate data) {
        List<HorarioAula> horariosDisponiveis = new ArrayList<>(Arrays.asList(HorarioAula.values()));
        List<Agenda> agendas = agendaRepository.getAgendasPorData(data);
        for (Agenda agenda : agendas) {
            HorarioAula horarioMarcado = HorarioAula.valueOf(agenda.getHorarioAula().toString());
            horariosDisponiveis.remove(horarioMarcado);
        }
        return horariosDisponiveis;
    }
}
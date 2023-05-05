package com.rlti.autoescola.agenda.application.repository;

import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.agenda.domain.HorarioAula;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import com.rlti.autoescola.instrutor.domain.Instrutor;
import com.rlti.autoescola.matricula.domain.Matricula;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AgendaRepository {
    Agenda saveAgenda(Agenda agenda);
    List<Agenda> getAllAgendas();
    Agenda getByIdAgenda(Long idAgenda);
    List<Agenda> getAgendaByIdInstrutor(Instrutor instrutor);
    List<Agenda> getAgendaByIdMatricula(Matricula matricula);
    List<Agenda> getAgendaByPlaca(Veiculo veiculo);
    void deleteAgenda(Long idAgenda);
    Optional<Agenda> getDataAndHorario(LocalDate data, HorarioAula horarioAula);
    List<Agenda> getAgendasPorData(LocalDate data);
    List<Agenda> getAgendasPorDataEInstrutor(LocalDate data, Instrutor instrutor);
    List<Agenda> getAgendasPorDataEVeiculo(LocalDate data, Veiculo veiculo);
}
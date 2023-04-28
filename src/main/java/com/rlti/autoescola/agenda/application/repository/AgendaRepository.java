package com.rlti.autoescola.agenda.application.repository;

import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import com.rlti.autoescola.instrutor.domain.Instrutor;
import com.rlti.autoescola.matricula.domain.Matricula;
import java.util.List;

public interface AgendaRepository {
    Agenda save(Agenda agenda);
    List<Agenda> buscaAgendamentos();
    Agenda getByIdAgenda(Long idAgenda);
    List<Agenda> getAgendaByIdInstrutor(Instrutor instrutor);
    List<Agenda> getAgendaByIdMatricula(Matricula matricula);
    List<Agenda> getAgendaByPlaca(Veiculo veiculo);
    void deleteAgenda(Long idAgenda);
}
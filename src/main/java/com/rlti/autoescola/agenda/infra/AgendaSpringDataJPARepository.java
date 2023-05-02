package com.rlti.autoescola.agenda.infra;

import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.agenda.domain.HorarioAula;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import com.rlti.autoescola.instrutor.domain.Instrutor;
import com.rlti.autoescola.matricula.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AgendaSpringDataJPARepository extends JpaRepository<Agenda, Long> {
    Optional<Agenda> findByIdAgenda(Long idAgenda);
    List<Agenda> findAgendaByInstrutor(Instrutor instrutor);
    List<Agenda> findAgendaByMatricula(Matricula matricula);
    List<Agenda> findAgendaByVeiculo(Veiculo veiculo);
    Optional<Agenda> findByDataAndHorarioAula(LocalDate data, HorarioAula horarioAula);
}
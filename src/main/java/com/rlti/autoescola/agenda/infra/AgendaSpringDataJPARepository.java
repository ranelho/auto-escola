package com.rlti.autoescola.agenda.infra;

import com.rlti.autoescola.agenda.domain.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AgendaSpringDataJPARepository extends JpaRepository<Agenda, Long> {

    Optional<Agenda> findById(Long idAgenda);
}
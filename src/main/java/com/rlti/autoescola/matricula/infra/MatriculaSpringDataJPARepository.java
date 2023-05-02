package com.rlti.autoescola.matricula.infra;

import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.matricula.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MatriculaSpringDataJPARepository extends JpaRepository<Matricula, UUID> {
    List<Matricula> findAllMatriculaByStatus(Status status);
}

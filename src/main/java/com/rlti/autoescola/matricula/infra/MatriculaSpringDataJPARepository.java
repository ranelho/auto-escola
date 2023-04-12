package com.rlti.autoescola.matricula.infra;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.matricula.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MatriculaSpringDataJPARepository extends JpaRepository<Matricula, UUID> {
}

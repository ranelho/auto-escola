package com.rlti.autoescola.exame.infra;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.exame.domain.Exame;
import com.rlti.autoescola.matricula.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExameSpringDataJPARepository extends JpaRepository<Exame, Long> {
    List<Exame> findByMatricula(Matricula matricula);
}

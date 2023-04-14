package com.rlti.autoescola.laudo.infra;

import com.rlti.autoescola.laudo.domain.Laudo;
import com.rlti.autoescola.matricula.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LaudoSpringJPARespository extends JpaRepository<Laudo, Long> {
    List<Laudo> findByMatricula(Matricula matricula);
}

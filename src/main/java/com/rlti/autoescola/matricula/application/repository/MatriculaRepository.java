package com.rlti.autoescola.matricula.application.repository;

import com.rlti.autoescola.matricula.domain.Matricula;

import java.util.List;
import java.util.UUID;

public interface MatriculaRepository {
    Matricula salva(Matricula matricula);

    List<Matricula> buscaTodasMatriculas();

    Matricula matriculaAtravesId(UUID idMatricula);
}

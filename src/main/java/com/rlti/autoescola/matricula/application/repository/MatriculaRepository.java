package com.rlti.autoescola.matricula.application.repository;

import com.rlti.autoescola.matricula.domain.Matricula;

import java.util.List;
import java.util.UUID;

public interface MatriculaRepository {
    Matricula saveMatricula(Matricula matricula);
    List<Matricula> getAllMatriculas();
    Matricula getOneMatricula(UUID idMatricula);
    void deleteMatricula(Matricula matricula);
    List<Matricula> getAllMatriculasAtivas();
}

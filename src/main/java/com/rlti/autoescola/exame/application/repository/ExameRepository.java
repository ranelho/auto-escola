package com.rlti.autoescola.exame.application.repository;

import com.rlti.autoescola.exame.domain.Exame;
import com.rlti.autoescola.matricula.domain.Matricula;

import java.util.List;

public interface ExameRepository {
    Exame saveExame(Exame exame);
    Exame getOneExame(Long idExame);
    List<Exame> getAllExamesByMatricula(Matricula matricula);
    void deleteExame(Long idExame);
    List<Exame> getAllExames();
}

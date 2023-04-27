package com.rlti.autoescola.laudo.application.repository;

import com.rlti.autoescola.laudo.domain.Laudo;
import com.rlti.autoescola.matricula.domain.Matricula;

import java.util.List;

public interface LaudoRepository {
    Laudo saveLaudo(Laudo laudo);
    void deleteLaudo(Long idLaudo);
    Laudo getOneLaudo(Long idLaudo);
    List<Laudo> getAllLaudosByMatricula(Matricula Matricula);
}
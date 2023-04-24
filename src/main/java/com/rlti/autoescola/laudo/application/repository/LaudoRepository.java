package com.rlti.autoescola.laudo.application.repository;

import com.rlti.autoescola.laudo.domain.Laudo;
import com.rlti.autoescola.matricula.domain.Matricula;

import java.util.List;

public interface LaudoRepository {
    Laudo salva(Laudo laudo);
    void delete(Long idLaudo);
    Laudo getById(Long idLaudo);
    List<Laudo> getLaudosByMatricula(Matricula Matricula);
}
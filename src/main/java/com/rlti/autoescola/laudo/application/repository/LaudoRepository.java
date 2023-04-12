package com.rlti.autoescola.laudo.application.repository;

import com.rlti.autoescola.laudo.domain.Laudo;
import com.rlti.autoescola.matricula.domain.Matricula;

public interface LaudoRepository {
    Laudo salva(Laudo laudo);
    Laudo getById(Long idLaudo);
    void deleta(Long idLaudo);
    Laudo getLaudoByMatricula(Matricula idMatricula);
}
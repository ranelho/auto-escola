package com.rlti.autoescola.laudo.application.repository;

import com.rlti.autoescola.laudo.domain.Laudo;

public interface LaudoRepository {
    Laudo salva(Laudo laudo);
    void deleta(Long idLaudo);
    Laudo getLaudoById(Long idLaudo);
}
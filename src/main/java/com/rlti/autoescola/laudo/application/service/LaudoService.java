package com.rlti.autoescola.laudo.application.service;

import com.rlti.autoescola.laudo.application.api.LaudoIdResponse;
import com.rlti.autoescola.laudo.application.api.LaudoRequest;
import com.rlti.autoescola.laudo.application.api.LaudoResponse;

import java.util.UUID;

public interface LaudoService {
    LaudoIdResponse postLaudo(UUID idMatricula, LaudoRequest request);
    LaudoResponse getLaudoByMatricula(UUID idMatricula);
    void update(UUID idMatricula, LaudoRequest request);
    void deleta(Long idLaudo);
}
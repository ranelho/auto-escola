package com.rlti.autoescola.laudo.application.service;

import com.rlti.autoescola.laudo.application.api.LaudoIdResponse;
import com.rlti.autoescola.laudo.application.api.LaudoRequest;
import com.rlti.autoescola.laudo.application.api.LaudoResponse;

import java.util.List;
import java.util.UUID;

public interface LaudoService {
    LaudoIdResponse postLaudo(UUID idMatricula, LaudoRequest request);
    LaudoResponse getLaudoById(Long idLaudo);
    void update(Long idLaudo, LaudoRequest request);
    void deleta(Long idLaudo);
    List<LaudoResponse> getLaudoByMatricula(UUID idMatricula);
}

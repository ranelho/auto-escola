package com.rlti.autoescola.laudo.application.service;

import com.rlti.autoescola.laudo.application.api.LaudoIdResponse;
import com.rlti.autoescola.laudo.application.api.LaudoRequest;
import com.rlti.autoescola.laudo.application.api.LaudoResponse;

import java.util.List;
import java.util.UUID;

public interface LaudoService {
    LaudoIdResponse post(UUID idMatricula, LaudoRequest request);
    LaudoResponse getById(Long idLaudo);
    void update(Long idLaudo, LaudoRequest request);
    void delete(Long idLaudo);
    List<LaudoResponse> getByMatricula(UUID idMatricula);
}

package com.rlti.autoescola.laudo.application.service;

import com.rlti.autoescola.laudo.application.api.LaudoIdResponse;
import com.rlti.autoescola.laudo.application.api.LaudoRequest;
import com.rlti.autoescola.laudo.application.api.LaudoResponse;

import java.util.List;
import java.util.UUID;

public interface LaudoService {
    LaudoIdResponse saveLaudo(UUID idMatricula, LaudoRequest request);
    LaudoResponse getOneLaudo(Long idLaudo);
    void updateLaudo(Long idLaudo, LaudoRequest request);
    void deleteLaudo(Long idLaudo);
    List<LaudoResponse> getAllLaudosByMatricula(UUID idMatricula);
}

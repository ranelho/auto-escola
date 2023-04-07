package com.rlti.autoescola.laudo.application.service;

import com.rlti.autoescola.laudo.application.api.LaudoIdResponse;
import com.rlti.autoescola.laudo.application.api.LaudoRequest;

import java.util.UUID;

public interface LaudoService {
    LaudoIdResponse postLadudo(UUID idMatricula, LaudoRequest request);
}

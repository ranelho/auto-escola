package com.rlti.autoescola.exame.application.service;

import com.rlti.autoescola.exame.application.api.ExameIdResponse;
import com.rlti.autoescola.exame.application.api.ExameRequest;

import java.util.UUID;

public interface ExameService {
    ExameIdResponse cadastrar(UUID idCliente, ExameRequest request);
}

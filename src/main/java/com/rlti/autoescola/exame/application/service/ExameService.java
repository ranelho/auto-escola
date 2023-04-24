package com.rlti.autoescola.exame.application.service;

import com.rlti.autoescola.exame.application.api.ExameIdResponse;
import com.rlti.autoescola.exame.application.api.ExameRequest;
import com.rlti.autoescola.exame.application.api.ExameResponse;

import java.util.List;
import java.util.UUID;

public interface ExameService {
    ExameIdResponse post(UUID idCliente, ExameRequest request);
    ExameResponse getById(Long idExame);
    List<ExameResponse> getAll(UUID idCliente);
    void delete(Long idExame);
    void update(Long idExame, ExameRequest request);
}

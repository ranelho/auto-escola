package com.rlti.autoescola.exame.application.service;

import com.rlti.autoescola.exame.application.api.ExameIdResponse;
import com.rlti.autoescola.exame.application.api.ExameRequest;
import com.rlti.autoescola.exame.application.api.ExameResponse;

import java.util.List;
import java.util.UUID;

public interface ExameService {
    ExameIdResponse saveExame(UUID idCliente, ExameRequest request);
    ExameResponse getOneExame(Long idExame);
    List<ExameResponse> getAllExames(UUID idCliente);
    void deleteExame(Long idExame);
    void updateExame(Long idExame, ExameRequest request);
}

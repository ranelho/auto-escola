package com.rlti.autoescola.exame.application.service;

import com.rlti.autoescola.exame.application.api.ExameIdResponse;
import com.rlti.autoescola.exame.application.api.ExameRequest;
import com.rlti.autoescola.exame.application.api.ExameResponse;

import java.util.List;
import java.util.UUID;

public interface ExameService {
    ExameIdResponse cadastrar(UUID idCliente, ExameRequest request);
    ExameResponse getExame(Long idExame);
    List<ExameResponse> listar(UUID idCliente);
    void deletar(Long idExame);
    void alterar(Long idExame, ExameRequest request);
}

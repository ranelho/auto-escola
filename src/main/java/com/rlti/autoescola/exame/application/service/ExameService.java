package com.rlti.autoescola.exame.application.service;

import com.rlti.autoescola.exame.application.api.*;

import java.util.List;
import java.util.UUID;

public interface ExameService {
    ExameIdResponse saveExame(UUID idMatricula, ExameRecord record);
    ExameResponseRecord getOneExame(Long idExame);
    List<ExameResponseRecord> getAllExames(UUID idMatricula);
    void deleteExame(Long idExame);
    void updateExame(Long idExame, ResultadoRequest request);
    List<ExameResponse> getAllExamesUser(String token);
}

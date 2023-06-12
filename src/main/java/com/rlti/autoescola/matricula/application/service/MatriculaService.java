package com.rlti.autoescola.matricula.application.service;

import com.rlti.autoescola.matricula.application.api.request.MatriculaUpdateRequest;
import com.rlti.autoescola.matricula.application.api.request.MatriculaRequest;
import com.rlti.autoescola.matricula.application.api.response.MatriculaDetalhadoResponse;
import com.rlti.autoescola.matricula.application.api.response.MatriculaIdResponse;
import com.rlti.autoescola.matricula.application.api.response.MatriculaListResponse;

import java.util.List;
import java.util.UUID;

public interface MatriculaService {
    MatriculaIdResponse saveMatricula(MatriculaRequest matriculaRequest);
    MatriculaIdResponse saveMatriculaByOrcamento(String cpf);
    List<MatriculaListResponse> getAllMatriculas();
    MatriculaDetalhadoResponse getOneMatricula(UUID idMatricula);
    void deleteMatricula(UUID idMatricula);
    void updateMatricula(UUID idMatricula, MatriculaUpdateRequest matriculaUpdateRequest);
    void finalizaMatricula(UUID idMatricula);
    void ativaMatricula(UUID idMatricula);
    void cancelaMatricula(UUID idMatricula);
}
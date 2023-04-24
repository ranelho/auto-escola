package com.rlti.autoescola.matricula.application.service;

import com.rlti.autoescola.matricula.application.api.request.MatriculaAlteracaoRequest;
import com.rlti.autoescola.matricula.application.api.request.MatriculaRequest;
import com.rlti.autoescola.matricula.application.api.response.MatriculaDetalhadoResponse;
import com.rlti.autoescola.matricula.application.api.response.MatriculaIdResponse;
import com.rlti.autoescola.matricula.application.api.response.MatriculaListResponse;

import java.util.List;
import java.util.UUID;

public interface MatriculaService {
    MatriculaIdResponse criaNovaMatricula(MatriculaRequest matriculaRequest);
    MatriculaIdResponse criaOrcamentoMatricula(String cpf);
    List<MatriculaListResponse> buscaTodasMatriculas();
    MatriculaDetalhadoResponse matriculaAtravesId(UUID idMatricula);
    void delete(UUID idMatricula);
    void update(UUID idMatricula, MatriculaAlteracaoRequest matriculaAlteracaoRequest);
    void finalizaMatricula(UUID idMatricula);
    void ativaMatricula(UUID idMatricula);
    void cancelaMatricula(UUID idMatricula);
}
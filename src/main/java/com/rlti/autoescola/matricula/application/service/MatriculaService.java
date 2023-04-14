package com.rlti.autoescola.matricula.application.service;

import com.rlti.autoescola.matricula.application.api.*;
import com.rlti.autoescola.matricula.application.api.request.MatriculaAlteracaoRequest;
import com.rlti.autoescola.matricula.application.api.request.MatriculaRequest;

import java.util.List;
import java.util.UUID;

public interface MatriculaService {

    MatriculaIdResponse criaNovaMatricula(MatriculaRequest matriculaRequest);

    List<MatriculaListResponse> buscaTodasMatriculas();

    MatriculaDetalhadoResponse matriculaAtravesId(UUID idMatricula);

    void deletaMatriculaAtravesId(UUID idMatricula);

    void patchAlteraMatricula(UUID idMatricula, MatriculaAlteracaoRequest matriculaAlteracaoRequest);
}

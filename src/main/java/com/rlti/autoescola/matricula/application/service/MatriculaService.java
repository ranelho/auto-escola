package com.rlti.autoescola.matricula.application.service;

import com.rlti.autoescola.matricula.application.api.MatriculaListResponse;
import com.rlti.autoescola.matricula.application.api.MatriculaRequest;
import com.rlti.autoescola.matricula.application.api.MatriculaResponse;

import java.util.List;

public interface MatriculaService {

    MatriculaResponse criaNovaMatricula(MatriculaRequest matriculaRequest);

    List<MatriculaListResponse> buscaTodasMatriculas();
}

package com.rlti.autoescola.matricula.application.service;

import com.rlti.autoescola.matricula.application.api.MatriculaRequest;
import com.rlti.autoescola.matricula.application.api.MatriculaResponse;

public interface MatriculaService {

    MatriculaResponse criaNovaMatricula(MatriculaRequest matriculaRequest);
}

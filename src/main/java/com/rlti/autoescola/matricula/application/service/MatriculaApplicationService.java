package com.rlti.autoescola.matricula.application.service;

import com.rlti.autoescola.matricula.application.api.MatriculaRequest;
import com.rlti.autoescola.matricula.application.api.MatriculaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MatriculaApplicationService implements MatriculaService{


    @Override
    public MatriculaResponse criaNovaMatricula(MatriculaRequest matriculaRequest) {
        log.info("[finaliza] MatriculaApplicationService - criaNovaMatricula");

        log.info("[finaliza] MatriculaApplicationService - criaNovaMatricula");
        return null;
    }
}

package com.rlti.autoescola.matricula.application.api;

import com.rlti.autoescola.matricula.application.service.MatriculaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class MatriculaRestController implements MatriculaAPI{
    private final MatriculaService matriculaService;

    @Override
    public MatriculaResponse criaMatricula(MatriculaRequest matriculaRequest) {
        log.info("[inicia] MatriculaRestController - criaMatricula");
        MatriculaResponse matriculaCriado = matriculaService.criaNovaMatricula(matriculaRequest);
        log.info("[finaliza] MatriculaRestController - criaMatricula");
        return matriculaCriado;
    }
}
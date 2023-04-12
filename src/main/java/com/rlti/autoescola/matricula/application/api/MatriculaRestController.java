package com.rlti.autoescola.matricula.application.api;

import com.rlti.autoescola.matricula.application.service.MatriculaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class MatriculaRestController implements MatriculaAPI{
    private final MatriculaService matriculaService;

    @Override
    public MatriculaResponse criaMatricula(MatriculaRequest matriculaRequest) {
        log.info("[inicia] MatriculaRestController - criaMatricula");
        MatriculaResponse matriculaCriado = matriculaService.criaNovaMatricula(matriculaRequest);
        log.info("[finaliza] MatriculaRestController - criaMatricula");
        return matriculaCriado;
    }

    @Override
    public List<MatriculaListResponse> getTodasMatriculas() {
        log.info("[inicia] MatriculaRestController - getTodasMatriculas");
        List<MatriculaListResponse> matriculas = matriculaService.buscaTodasMatriculas();
        log.info("[finaliza] MatriculaRestController - getTodasMatriculas");
        return matriculas;
    }

    @Override
    public MatriculaDetalhadoResponse getMatriculaAtravesId(UUID idMatricula) {
        log.info("[inicia] MatriculaRestController - getMatriculaAtravesId");
        log.info("idMatricula {}", idMatricula);
        MatriculaDetalhadoResponse matriculaDetalhadoResponse = matriculaService.matriculaAtravesId(idMatricula);
        log.info("[finaliza] MatriculaRestController - getMatriculaAtravesId");
        return matriculaDetalhadoResponse;
    }

    @Override
    public void deletaMatriculaAtravesId(UUID idMatricula) {
        log.info("[inicia] MatriculaRestController - deletaMatriculaAtravesId");
        matriculaService.deletaMatriculaAtravesId(idMatricula);
        log.info("[finaliza] MatriculaRestController - deletaMatriculaAtravesId");
    }

    @Override
    public void patchAlteraMatricula(UUID idMatricula, @Valid MatriculaAlteracaoRequest matriculaAlteracaoRequest) {
        log.info("[inicia] MatriculaRestController - patchAlteraMatricula");
        matriculaService.patchAlteraMatricula(idMatricula, matriculaAlteracaoRequest);
        log.info("[finaliza] MatriculaRestController - patchAlteraMatricula");
    }
}

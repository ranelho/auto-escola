package com.rlti.autoescola.matricula.application.api;

import com.rlti.autoescola.matricula.application.api.request.MatriculaAlteracaoRequest;
import com.rlti.autoescola.matricula.application.api.request.MatriculaRequest;
import com.rlti.autoescola.matricula.application.api.response.MatriculaDetalhadoResponse;
import com.rlti.autoescola.matricula.application.api.response.MatriculaIdResponse;
import com.rlti.autoescola.matricula.application.api.response.MatriculaListResponse;
import com.rlti.autoescola.matricula.application.service.MatriculaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class MatriculaRestController implements MatriculaAPI{
    private final MatriculaService matriculaService;

    @Override
    public MatriculaIdResponse saveMatricula(MatriculaRequest matriculaRequest) {
        log.info("[inicia] MatriculaRestController - post");
        MatriculaIdResponse matriculaCriado = matriculaService.saveMatricula(matriculaRequest);
        log.info("[finaliza] MatriculaRestController - post");
        return matriculaCriado;
    }

    @Override
    public MatriculaIdResponse saveMatriculaByOrcamento(String cpf) {
        log.info("[inicia] MatriculaRestController - post-orcamento");
        MatriculaIdResponse matriculaCriado = matriculaService.saveMatriculaByOrcamento(cpf);
        log.info("[finaliza] MatriculaRestController - post-orcamento");
        return matriculaCriado;
    }

    @Override
    public List<MatriculaListResponse> getAllMatriculas() {
        log.info("[inicia] MatriculaRestController - getAll");
        List<MatriculaListResponse> matriculas = matriculaService.getAllMatriculas();
        log.info("[finaliza] MatriculaRestController - getAll");
        return matriculas;
    }

    @Override
    public MatriculaDetalhadoResponse getOneMatricula(UUID idMatricula) {
        log.info("[inicia] MatriculaRestController - getById");
        log.info("idMatricula {}", idMatricula);
        MatriculaDetalhadoResponse matriculaDetalhadoResponse = matriculaService.getOneMatricula(idMatricula);
        log.info("[finaliza] MatriculaRestController - getById");
        return matriculaDetalhadoResponse;
    }

    @Override
    public void deleteMatricula(UUID idMatricula) {
        log.info("[inicia] MatriculaRestController - delete");
        matriculaService.deleteMatricula(idMatricula);
        log.info("[finaliza] MatriculaRestController - delete");
    }

    @Override
    public void updateMatricula(UUID idMatricula, @Valid MatriculaAlteracaoRequest matriculaAlteracaoRequest) {
        log.info("[inicia] MatriculaRestController - update");
        matriculaService.updateMatricula(idMatricula, matriculaAlteracaoRequest);
        log.info("[finaliza] MatriculaRestController - update");
    }

    @Override
    public void finalizaMatricula(UUID idMatricula) {
        log.info("[inicia] MatriculaRestController - finalizaMatricula");
        matriculaService.finalizaMatricula(idMatricula);
        log.info("[finaliza] MatriculaRestController - finalizaMatricula");
    }

    @Override
    public void ativaMatricula(UUID idMatricula) {
        log.info("[inicia] MatriculaRestController - ativaMatricula");
        matriculaService.ativaMatricula(idMatricula);
        log.info("[finaliza] MatriculaRestController - ativaMatricula");
    }

    @Override
    public void cancelaMatricula(UUID idMatricula) {
        log.info("[inicia] MatriculaRestController - cancelaMatricula");
        matriculaService.cancelaMatricula(idMatricula);
        log.info("[finaliza] MatriculaRestController - cancelaMatricula");
    }
}

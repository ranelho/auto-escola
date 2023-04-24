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
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class MatriculaRestController implements MatriculaAPI{
    private final MatriculaService matriculaService;

    @Override
    public MatriculaIdResponse post(MatriculaRequest matriculaRequest) {
        log.info("[inicia] MatriculaRestController - post");
        MatriculaIdResponse matriculaCriado = matriculaService.criaNovaMatricula(matriculaRequest);
        log.info("[finaliza] MatriculaRestController - post");
        return matriculaCriado;
    }

    @Override
    public MatriculaIdResponse post(String cpf) {
        log.info("[inicia] MatriculaRestController - post-orcamento");
        MatriculaIdResponse matriculaCriado = matriculaService.criaOrcamentoMatricula(cpf);
        log.info("[finaliza] MatriculaRestController - post-orcamento");
        return matriculaCriado;
    }

    @Override
    public List<MatriculaListResponse> getAll() {
        log.info("[inicia] MatriculaRestController - getAll");
        List<MatriculaListResponse> matriculas = matriculaService.buscaTodasMatriculas();
        log.info("[finaliza] MatriculaRestController - getAll");
        return matriculas;
    }

    @Override
    public MatriculaDetalhadoResponse getById(UUID idMatricula) {
        log.info("[inicia] MatriculaRestController - getById");
        log.info("idMatricula {}", idMatricula);
        MatriculaDetalhadoResponse matriculaDetalhadoResponse = matriculaService.matriculaAtravesId(idMatricula);
        log.info("[finaliza] MatriculaRestController - getById");
        return matriculaDetalhadoResponse;
    }

    @Override
    public void delete(UUID idMatricula) {
        log.info("[inicia] MatriculaRestController - delete");
        matriculaService.delete(idMatricula);
        log.info("[finaliza] MatriculaRestController - delete");
    }

    @Override
    public void update(UUID idMatricula, @Valid MatriculaAlteracaoRequest matriculaAlteracaoRequest) {
        log.info("[inicia] MatriculaRestController - update");
        matriculaService.update(idMatricula, matriculaAlteracaoRequest);
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

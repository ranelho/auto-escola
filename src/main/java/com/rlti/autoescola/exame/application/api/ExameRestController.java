package com.rlti.autoescola.exame.application.api;

import com.rlti.autoescola.exame.application.service.ExameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ExameRestController implements ExameApi {
    private final ExameService exameService;

    @Override
    public ExameIdResponse post(UUID idCliente, ExameRequest request) {
        log.info("[inicia] ExameRestController - post");
        ExameIdResponse idResponse = exameService.post(idCliente, request);
        log.info("[finaliza] ExameRestController - post");
        return idResponse;
    }

    @Override
    public ExameResponse getById(Long idExame) {
        log.info("[inicia] ExameRestController - getById");
        ExameResponse response = exameService.getById(idExame);
        log.info("[finaliza] ExameRestController - getById");
        return response;
    }

    @Override
    public List<ExameResponse> getAll(UUID idCliente) {
        log.info("[inicia] ExameRestController - getAll");
        List<ExameResponse> response = exameService.getAll(idCliente);
        log.info("[finaliza] ExameRestController - getAll");
        return response;
    }

    @Override
    public void delete(Long idExame) {
        log.info("[inicia] ExameRestController - delete");
        exameService.delete(idExame);
        log.info("[finaliza] ExameRestController - delete");
    }

    @Override
    public void update(Long idExame, ExameRequest request) {
        log.info("[inicia] ExameRestController - update");
        exameService.update(idExame, request);
        log.info("[finaliza] ExameRestController - update");
    }
}
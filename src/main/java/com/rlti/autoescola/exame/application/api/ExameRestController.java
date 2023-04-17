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
    public ExameIdResponse cadastrar(UUID idCliente, ExameRequest request) {
        log.info("[inicia] ExameRestController - cadastrar");
        ExameIdResponse idResponse = exameService.cadastrar(idCliente, request);
        log.info("[finaliza] ExameRestController - cadastrar");
        return idResponse;
    }

    @Override
    public ExameResponse getExame(Long idExame) {
        log.info("[inicia] ExameRestController - getExame");
        ExameResponse response = exameService.getExame(idExame);
        log.info("[finaliza] ExameRestController - getExame");
        return response;
    }

    @Override
    public List<ExameResponse> listar(UUID idCliente) {
        log.info("[inicia] ExameRestController - listar");
        List<ExameResponse> response = exameService.listar(idCliente);
        log.info("[finaliza] ExameRestController - listar");
        return response;
    }

    @Override
    public void deletar(Long idExame) {
        log.info("[inicia] ExameRestController - deletar");
        exameService.deletar(idExame);
        log.info("[finaliza] ExameRestController - deletar");
    }

    @Override
    public void alterar(Long idExame, ExameRequest request) {
        log.info("[inicia] ExameRestController - alterar");
        exameService.alterar(idExame, request);
        log.info("[finaliza] ExameRestController - alterar");
    }
}
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
    public ExameIdResponse saveExame(UUID idCliente, ExameRequest request) {
        log.info("[inicia] ExameRestController - saveExame");
        ExameIdResponse idResponse = exameService.saveExame(idCliente, request);
        log.info("[finaliza] ExameRestController - saveExame");
        return idResponse;
    }

    @Override
    public ExameResponse getOneExame(Long idExame) {
        log.info("[inicia] ExameRestController - getOneExame");
        ExameResponse response = exameService.getOneExame(idExame);
        log.info("[finaliza] ExameRestController - getOneExame");
        return response;
    }

    @Override
    public List<ExameResponse> getAllExames(UUID idCliente) {
        log.info("[inicia] ExameRestController - getAllExames");
        List<ExameResponse> response = exameService.getAllExames(idCliente);
        log.info("[finaliza] ExameRestController - getAllExames");
        return response;
    }

    @Override
    public void deleteExame(Long idExame) {
        log.info("[inicia] ExameRestController - deleteExame");
        exameService.deleteExame(idExame);
        log.info("[finaliza] ExameRestController - deleteExame");
    }

    @Override
    public void updateExame(Long idExame, ExameRequest request) {
        log.info("[inicia] ExameRestController - updateExame");
        exameService.updateExame(idExame, request);
        log.info("[finaliza] ExameRestController - updateExame");
    }
}
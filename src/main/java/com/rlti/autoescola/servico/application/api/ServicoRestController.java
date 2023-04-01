package com.rlti.autoescola.servico.application.api;

import com.rlti.autoescola.servico.application.service.ServicoService;
import com.rlti.autoescola.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ServicoRestController implements ServicoApi {
    private final ServicoService servicoService;

    @Override
    public ServicoIdResponse saveFrota(ServicoRequest request) {
        log.info("[inicia] ServicoRestController - saveFrota");
        ServicoIdResponse idResponse = servicoService.saveFrota(request);
        log.info("[finaliza] ServicoRestController - saveFrota");
        return idResponse;
    }

    @Override
    public ServicoResponse getById(UUID idServico) {
        log.info("[inicia] ServicoRestController - saveFrota");
        Servico servico = servicoService.getById(idServico);
        log.info("[finaliza] ServicoRestController - saveFrota");
        return new ServicoResponse(servico);
    }

    @Override
    public List<ServicoResponse> getAll() {
        log.info("[inicia] ServicoRestController - getAll");
        List<Servico> servicos = servicoService.getAll();
        log.info("[finaliza] ServicoRestController - getAll");
        return ServicoResponse.converte(servicos);
    }

    @Override
    public void alteraServico(UUID idServico, ServicoRequest request) {
        log.info("[inicia] ServicoRestController - alteraServico");
        servicoService.alteraServico(idServico, request);
        log.info("[finaliza] ServicoRestController - alteraServico");
    }
}
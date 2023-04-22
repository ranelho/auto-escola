package com.rlti.autoescola.servico.application.api;

import com.rlti.autoescola.servico.application.service.ServicoService;
import com.rlti.autoescola.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ServicoRestController implements ServicoApi {
    private final ServicoService servicoService;

    @Override
    public ServicoIdResponse post(ServicoRequest request) {
        log.info("[inicia] ServicoRestController - post");
        ServicoIdResponse idResponse = servicoService.post(request);
        log.info("[finaliza] ServicoRestController - post");
        return idResponse;
    }

    @Override
    public ServicoResponse getById(UUID idServico) {
        log.info("[inicia] ServicoRestController - post");
        Servico servico = servicoService.getById(idServico);
        log.info("[finaliza] ServicoRestController - post");
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
    public void delete(UUID idServico) {
        log.info("[inicia] ServicoRestController - delete");
        servicoService.delete(idServico);
        log.info("[finaliza] ServicoRestController - delete");
    }

    @Override
    public void update(UUID idServico, ServicoUpdateRequest updateRequest) {
        log.info("[inicia] ServicoRestController - update");
        servicoService.update(idServico, updateRequest);
        log.info("[finaliza] ServicoRestController - update");
    }

}
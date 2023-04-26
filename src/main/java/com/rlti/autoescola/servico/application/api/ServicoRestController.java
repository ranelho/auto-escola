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
    public ServicoIdResponse saveServico(ServicoRequest request) {
        log.info("[inicia] ServicoRestController - post");
        ServicoIdResponse idResponse = servicoService.saveServico(request);
        log.info("[finaliza] ServicoRestController - post");
        return idResponse;
    }

    @Override
    public ServicoResponse getOneServico(UUID idServico) {
        log.info("[inicia] ServicoRestController - post");
        Servico servico = servicoService.getOneServico(idServico);
        log.info("[finaliza] ServicoRestController - post");
        return new ServicoResponse(servico);
    }

    @Override
    public List<ServicoResponse> getAllServicos() {
        log.info("[inicia] ServicoRestController - getAll");
        List<Servico> servicos = servicoService.getAllServicos();
        log.info("[finaliza] ServicoRestController - getAll");
        return ServicoResponse.converte(servicos);
    }

    @Override
    public void deleteServico(UUID idServico) {
        log.info("[inicia] ServicoRestController - delete");
        servicoService.deleteServico(idServico);
        log.info("[finaliza] ServicoRestController - delete");
    }

    @Override
    public void updateServico(UUID idServico, ServicoUpdateRequest updateRequest) {
        log.info("[inicia] ServicoRestController - update");
        servicoService.updateServico(idServico, updateRequest);
        log.info("[finaliza] ServicoRestController - update");
    }

}
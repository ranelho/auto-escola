package com.rlti.autoescola.servico.application.service;

import com.rlti.autoescola.servico.application.api.ServicoIdResponse;
import com.rlti.autoescola.servico.application.api.ServicoRequest;
import com.rlti.autoescola.servico.application.api.ServicoUpdateRequest;
import com.rlti.autoescola.servico.application.repository.ServicoRepository;
import com.rlti.autoescola.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class ServicoApplicationService implements ServicoService {
    private final ServicoRepository servicoRepository;

    @Override
    public ServicoIdResponse saveServico(ServicoRequest request) {
        log.info("[inicia] ServicoApplicationService - saveServico");
        Servico servico = servicoRepository.salvaServico(new Servico(request));
        log.info("[finaliza] ServicoApplicationService - saveServico");
        return ServicoIdResponse
                .builder()
                .idServico(servico.getIdServico())
                .build();
    }

    @Override
    public Servico getOneServico(UUID idServico) {
        log.info("[inicia] ServicoApplicationService - getOneServico");
        Servico servico = servicoRepository.getOneServico(idServico);
        log.info("[finaliza] ServicoApplicationService - getOneServico");
        return servico;
    }

    @Override
    public List<Servico> getAllServicos() {
        log.info("[inicia] ServicoApplicationService - getAllServicos");
        List<Servico> servicos = servicoRepository.getAllServicos();
        log.info("[finaliza] ServicoApplicationService - getAllServicos");
        return servicos;
    }

    @Override
    public void deleteServico(UUID idServico) {
        log.info("[inicia] ServicoApplicationService - deleteServico");
        servicoRepository.deleteServico(servicoRepository.getOneServico(idServico).getIdServico());
        log.info("[finaliza] ServicoApplicationService - deleteServico");
    }

    @Override
    public void updateServico(UUID idServico, ServicoUpdateRequest updateRequest) {
        log.info("[inicia] ServicoApplicationService - updateServico");
        Servico servico = servicoRepository.getOneServico(idServico);
        servico.altera(updateRequest);
        servicoRepository.salvaServico(servico);
        log.info("[finaliza] ServicoApplicationService - updateServico");
    }

    @Override
    public void updateServicoStatus(UUID idServico) {
        log.info("[inicia] ServicoApplicationService - updateServicoStatus");
        Servico servico = servicoRepository.getOneServico(idServico);
        servico.alteraStatus();
        servicoRepository.salvaServico(servico);
        log.info("[finaliza] ServicoApplicationService - updateServicoStatus");
    }
}
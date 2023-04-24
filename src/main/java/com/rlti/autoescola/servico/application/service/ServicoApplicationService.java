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
    public ServicoIdResponse post(ServicoRequest request) {
        log.info("[inicia] ServicoApplicationService - post");
        Servico servico = servicoRepository.salva(new Servico(request));
        log.info("[finaliza] ServicoApplicationService - post");
        return ServicoIdResponse
                .builder()
                .idServico(servico.getIdServico())
                .build();
    }

    @Override
    public Servico getById(UUID idServico) {
        log.info("[inicia] ServicoApplicationService - getById");
        Servico servico = servicoRepository.getById(idServico);
        log.info("[finaliza] ServicoApplicationService - getById");
        return servico;
    }

    @Override
    public List<Servico> getAll() {
        log.info("[inicia] ServicoApplicationService - getAll");
        List<Servico> servicos = servicoRepository.getAll();
        log.info("[finaliza] ServicoApplicationService - getAll");
        return servicos;
    }

    @Override
    public void delete(UUID idServico) {
        log.info("[inicia] ServicoApplicationService - delete");
        servicoRepository.delete(servicoRepository.getById(idServico).getIdServico());
        log.info("[finaliza] ServicoApplicationService - delete");
    }

    @Override
    public void update(UUID idServico, ServicoUpdateRequest updateRequest) {
        log.info("[inicia] ServicoApplicationService - delete");
        Servico servico = servicoRepository.getById(idServico);
        servico.altera(updateRequest);
        servicoRepository.salva(servico);
        log.info("[finaliza] ServicoApplicationService - delete");
    }
}
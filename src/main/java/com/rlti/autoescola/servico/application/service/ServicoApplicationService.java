package com.rlti.autoescola.servico.application.service;

import com.rlti.autoescola.servico.application.api.ServicoIdResponse;
import com.rlti.autoescola.servico.application.api.ServicoRequest;
import com.rlti.autoescola.servico.application.repository.ServicoRepository;
import com.rlti.autoescola.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class ServicoApplicationService implements ServicoService {
    private final ServicoRepository servicoRepository;

    @Override
    public ServicoIdResponse saveFrota(ServicoRequest request) {
        log.info("[inicia] ServicoApplicationService - saveFrota");
        Servico servico = servicoRepository.salva(new Servico(request));
        log.info("[finaliza] ServicoApplicationService - saveFrota");
        return ServicoIdResponse
                .builder()
                .idServico(servico.getIdServico())
                .build();
    }
}

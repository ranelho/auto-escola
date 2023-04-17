package com.rlti.autoescola.exame.application.service;

import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.exame.application.api.ExameIdResponse;
import com.rlti.autoescola.exame.application.api.ExameRequest;
import com.rlti.autoescola.exame.application.repository.ExameRepository;
import com.rlti.autoescola.exame.domain.Exame;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class ExameApplicationService implements ExameService {
    private final ExameRepository exameRepository;
    private final ClienteRepository clienteRepository;

    @Override
    public ExameIdResponse cadastrar(UUID idCliente, ExameRequest request) {
        log.info("[inicia] ExameApplicationService - cadastrar");
        Cliente cliente = clienteRepository.buscaClientePorId(idCliente);
        Exame exame = exameRepository.salva(new Exame(cliente, request));
        log.info("[finaliza] ExameApplicationService - cadastrar");
        return ExameIdResponse.builder().idExame(exame.getIdExame()).build();
    }
}

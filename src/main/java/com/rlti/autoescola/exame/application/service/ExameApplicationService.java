package com.rlti.autoescola.exame.application.service;

import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.exame.application.api.ExameIdResponse;
import com.rlti.autoescola.exame.application.api.ExameRequest;
import com.rlti.autoescola.exame.application.api.ExameResponse;
import com.rlti.autoescola.exame.application.repository.ExameRepository;
import com.rlti.autoescola.exame.domain.Exame;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class ExameApplicationService implements ExameService {
    private final ExameRepository exameRepository;
    private final ClienteRepository clienteRepository;

    @Override
    public ExameIdResponse saveExame(UUID idCliente, ExameRequest request) {
        log.info("[inicia] ExameApplicationService - post");
        Cliente cliente = clienteRepository.findById(idCliente);
        Exame exame = exameRepository.salva(new Exame(cliente, request));
        log.info("[finaliza] ExameApplicationService - post");
        return ExameIdResponse.builder().idExame(exame.getIdExame()).build();
    }

    @Override
    public ExameResponse getOneExame(Long idExame) {
        log.info("[inicia] ExameApplicationService - getById");
        Exame exame = exameRepository.buscaExamePorId(idExame);
        log.info("[finaliza] ExameApplicationService - getById");
        return new ExameResponse(exame);
    }

    @Override
    public List<ExameResponse> getAllExames(UUID idCliente) {
        log.info("[inicia] ExameApplicationService - getAll");
        Cliente cliente = clienteRepository.findById(idCliente);
        List<Exame> exames = exameRepository.buscaExamesPorIdCliente(cliente);
        log.info("[finaliza] ExameApplicationService - getAll");
        return ExameResponse.converte(exames);
    }

    @Override
    public void deleteExame(Long idExame) {
        log.info("[inicia] ExameApplicationService - delete");
        exameRepository.delete(exameRepository.buscaExamePorId(idExame).getIdExame());
        log.info("[finaliza] ExameApplicationService - delete");
    }

    @Override
    public void updateExame(Long idExame, ExameRequest request) {
        log.info("[inicia] ExameApplicationService - update");
        Exame exame = exameRepository.buscaExamePorId(idExame);
        exame.altera(request);
        exameRepository.salva(exame);
        log.info("[finaliza] ExameApplicationService - update");
    }
}
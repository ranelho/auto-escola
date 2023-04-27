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
        log.info("[inicia] ExameApplicationService - saveExame");
        Cliente cliente = clienteRepository.findOneCliente(idCliente);
        Exame exame = exameRepository.saveExame(new Exame(cliente, request));
        log.info("[finaliza] ExameApplicationService - saveExame");
        return ExameIdResponse.builder().idExame(exame.getIdExame()).build();
    }

    @Override
    public ExameResponse getOneExame(Long idExame) {
        log.info("[inicia] ExameApplicationService - getOneExame");
        Exame exame = exameRepository.getOneExame(idExame);
        log.info("[finaliza] ExameApplicationService - getOneExame");
        return new ExameResponse(exame);
    }

    @Override
    public List<ExameResponse> getAllExames(UUID idCliente) {
        log.info("[inicia] ExameApplicationService - getAllExames");
        Cliente cliente = clienteRepository.findOneCliente(idCliente);
        List<Exame> exames = exameRepository.getAllExamesByCliente(cliente);
        log.info("[finaliza] ExameApplicationService - getAllExames");
        return ExameResponse.converte(exames);
    }

    @Override
    public void deleteExame(Long idExame) {
        log.info("[inicia] ExameApplicationService - deleteExame");
        exameRepository.deleteExame(exameRepository.getOneExame(idExame).getIdExame());
        log.info("[finaliza] ExameApplicationService - deleteExame");
    }

    @Override
    public void updateExame(Long idExame, ExameRequest request) {
        log.info("[inicia] ExameApplicationService - updateExame");
        Exame exame = exameRepository.getOneExame(idExame);
        exame.altera(request);
        exameRepository.saveExame(exame);
        log.info("[finaliza] ExameApplicationService - updateExame");
    }
}
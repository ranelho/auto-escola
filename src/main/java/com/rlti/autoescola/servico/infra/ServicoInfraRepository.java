package com.rlti.autoescola.servico.infra;

import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.servico.application.repository.ServicoRepository;
import com.rlti.autoescola.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ServicoInfraRepository implements ServicoRepository {
    private final ServicoSpringDataInfraRepository servicoSpringDataInfraRepository;

    @Override
    public Servico salva(Servico servico) {
        log.info("[inicia] ServicoInfraRepository - salva");
        try {
            servicoSpringDataInfraRepository.save(servico);
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Serviço já cadastrado", e);
        }
        log.info("[finaliza] ServicoInfraRepository - salva");
        return servico;
    }

    @Override
    public Servico getById(UUID idServico) {
        log.info("[inicia] ServicoInfraRepository - getById");
        Optional<Servico> optionalServico = servicoSpringDataInfraRepository.findById(idServico);
        Servico servico = optionalServico
                .orElseThrow(
                        () -> APIException.build(HttpStatus.BAD_REQUEST, "Serviço não encontrado")
                );
        log.info("[finaliza] ServicoInfraRepository - getById");
        return servico;
    }

    @Override
    public List<Servico> getAll() {
        log.info("[inicia] ServicoInfraRepository - getAll");
        List<Servico> servicos = servicoSpringDataInfraRepository.findAll();
        log.info("[finaliza] ServicoInfraRepository - getAll");
        return servicos;
    }

    @Override
    public void delete(UUID idServico) {
        log.info("[inicia] ServicoInfraRepository - getAll");
        servicoSpringDataInfraRepository.deleteById(idServico);
        log.info("[finaliza] ServicoInfraRepository - getAll");
    }
}
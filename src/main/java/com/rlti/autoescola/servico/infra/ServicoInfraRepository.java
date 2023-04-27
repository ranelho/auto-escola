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
    public Servico salvaServico(Servico servico) {
        log.info("[inicia] ServicoInfraRepository - salvaServico");
        try {
            servicoSpringDataInfraRepository.save(servico);
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Serviço já cadastrado", e);
        }
        log.info("[finaliza] ServicoInfraRepository - salvaServico");
        return servico;
    }

    @Override
    public Servico getOneServico(UUID idServico) {
        log.info("[inicia] ServicoInfraRepository - getOneServico");
        Optional<Servico> optionalServico = servicoSpringDataInfraRepository.findById(idServico);
        Servico servico = optionalServico
                .orElseThrow(
                        () -> APIException.build(HttpStatus.BAD_REQUEST, "Serviço não encontrado")
                );
        log.info("[finaliza] ServicoInfraRepository - getOneServico");
        return servico;
    }

    @Override
    public List<Servico> getAllServicos() {
        log.info("[inicia] ServicoInfraRepository - getAllServicos");
        List<Servico> servicos = servicoSpringDataInfraRepository.findAll();
        log.info("[finaliza] ServicoInfraRepository - getAllServicos");
        return servicos;
    }

    @Override
    public void deleteServico(UUID idServico) {
        log.info("[inicia] ServicoInfraRepository - deleteServico");
        servicoSpringDataInfraRepository.deleteById(idServico);
        log.info("[finaliza] ServicoInfraRepository - deleteServico");
    }
}
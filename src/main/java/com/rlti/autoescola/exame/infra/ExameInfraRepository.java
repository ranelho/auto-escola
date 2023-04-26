package com.rlti.autoescola.exame.infra;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.exame.application.repository.ExameRepository;
import com.rlti.autoescola.exame.domain.Exame;
import com.rlti.autoescola.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ExameInfraRepository implements ExameRepository {
    private final ExameSpringDataJPARepository exameSpringDataJPARepository;

    @Override
    public Exame saveExame(Exame exame) {
        log.info("[inicia] ExameInfraRepository -  salva");
        exameSpringDataJPARepository.save(exame);
        log.info("[finaliza] ExameInfraRepository -  salva");
        return exame;
    }

    @Override
    public Exame getOneExame(Long idExame) {
        log.info("[inicia] ExameInfraRepository -  buscaExamePorId");
        Optional<Exame> optionalExame = exameSpringDataJPARepository.findById(idExame);
        Exame exame = optionalExame
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Exame não encontrado"));
        log.info("[finaliza] ExameInfraRepository -  buscaExamePorId");
        return exame;
    }

    @Override
    public List<Exame> getAllExamesByCliente(Cliente cliente) {
        log.info("[inicia] ExameInfraRepository -  buscaExamesPorIdCliente");
        List<Exame> exames = exameSpringDataJPARepository.findByCliente(cliente);
        log.info("[finaliza] ExameInfraRepository -  buscaExamesPorIdCliente");
        return exames;
    }

    @Override
    public void deleteExame(Long idExame) {
        log.info("[inicia] ExameInfraRepository -  delete");
        exameSpringDataJPARepository.deleteById(idExame);
        log.info("[finaliza] ExameInfraRepository -  delete");
    }
}

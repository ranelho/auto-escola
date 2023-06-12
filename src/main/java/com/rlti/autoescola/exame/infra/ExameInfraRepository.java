package com.rlti.autoescola.exame.infra;

import com.rlti.autoescola.exame.application.repository.ExameRepository;
import com.rlti.autoescola.exame.domain.Exame;
import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.matricula.domain.Matricula;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ExameInfraRepository implements ExameRepository {
    private final ExameSpringDataJPARepository exameSpringDataJPARepository;

    @Override
    public Exame saveExame(Exame exame) {
        log.info("[inicia] ExameInfraRepository -  saveExame");
        exameSpringDataJPARepository.save(exame);
        log.info("[finaliza] ExameInfraRepository -  saveExame");
        return exame;
    }

    @Override
    public Exame getOneExame(Long idExame) {
        log.info("[inicia] ExameInfraRepository -  getOneExame");
        Optional<Exame> optionalExame = exameSpringDataJPARepository.findById(idExame);
        Exame exame = optionalExame
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Exame não encontrado"));
        log.info("[finaliza] ExameInfraRepository -  getOneExame");
        return exame;
    }

    @Override
    public List<Exame> getAllExamesByMatricula(Matricula matricula) {
        log.info("[inicia] ExameInfraRepository -  getAllExamesByCliente");
        List<Exame> exames = exameSpringDataJPARepository.findByMatricula(matricula);
        log.info("[finaliza] ExameInfraRepository -  getAllExamesByCliente");
        return exames;
    }

    @Override
    public void deleteExame(Long idExame) {
        log.info("[inicia] ExameInfraRepository -  deleteExame");
        exameSpringDataJPARepository.deleteById(idExame);
        log.info("[finaliza] ExameInfraRepository -  deleteExame");
    }

    @Override
    public List<Exame> getAllExames() {
        log.info("[inicia] ExameInfraRepository -  getAllExames");
        List<Exame> exames = exameSpringDataJPARepository.findAll();
        log.info("[finaliza] ExameInfraRepository -  getAllExames");
        return exames;
    }
}

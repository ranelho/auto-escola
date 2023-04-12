package com.rlti.autoescola.matricula.application.repository;

import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.matricula.infra.MatriculaSpringDataJPARepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class MatriculaInfraRepository implements MatriculaRepository {
    private final MatriculaSpringDataJPARepository matriculaSpringDataJPARepository;

    @Override
    public Matricula salva(Matricula matricula) {
        log.info("[inicia] MatriculaInfraRepository - salva");
        matriculaSpringDataJPARepository.save(matricula);
        log.info("[finaliza] MatriculaInfraRepository - salva");
        return matricula;
    }

    @Override
    public List<Matricula> buscaTodasMatriculas() {
        log.info("[inicia] MatriculaInfraRepository - buscaTodasMatriculas");
        List<Matricula> todasMatriculas = matriculaSpringDataJPARepository.findAll();
        log.info("[finaliza] MatriculaInfraRepository - buscaTodasMatriculas");
        return todasMatriculas;
    }

    @Override
    public Matricula matriculaAtravesId(UUID idMatricula) {
        log.info("[inicia] MatriculaInfraRepository - matriculaAtravesId");
        Matricula matricula = matriculaSpringDataJPARepository.findById(idMatricula)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Matricula não encontrado!"));
        log.info("[finaliza] MatriculaInfraRepository - matriculaAtravesId");
        return matricula;
    }

    @Override
    public void deletaMatricula(Matricula matricula) {
        log.info("[inicia] MatriculaInfraRepository - deletaMatricula");
        matriculaSpringDataJPARepository.delete(matricula);
        log.info("[finaliza] MatriculaInfraRepository - deletaMatricula");
    }
}




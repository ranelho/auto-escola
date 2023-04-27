package com.rlti.autoescola.matricula.infra;

import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.matricula.application.repository.MatriculaRepository;
import com.rlti.autoescola.matricula.domain.Matricula;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class MatriculaInfraRepository implements MatriculaRepository {
    private final MatriculaSpringDataJPARepository matriculaSpringDataJPARepository;

    @Override
    public Matricula saveMatricula(Matricula matricula) {
        log.info("[inicia] MatriculaInfraRepository - saveMatricula");
        matriculaSpringDataJPARepository.save(matricula);
        log.info("[finaliza] MatriculaInfraRepository - saveMatricula");
        return matricula;
    }

    @Override
    public List<Matricula> getAllMatriculas() {
        log.info("[inicia] MatriculaInfraRepository - getAllMatriculas");
        List<Matricula> todasMatriculas = matriculaSpringDataJPARepository.findAll();
        log.info("[finaliza] MatriculaInfraRepository - getAllMatriculas");
        return todasMatriculas;
    }

    @Override
    public Matricula getOneMatricula(UUID idMatricula) {
        log.info("[inicia] MatriculaInfraRepository - getOneMatricula");
        Optional<Matricula> matriculaOptional = matriculaSpringDataJPARepository.findById(idMatricula);
        Matricula matricula = matriculaOptional
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Matricula não encontrado!"));
        log.info("[finaliza] MatriculaInfraRepository - getOneMatricula");
        return matricula;
    }

    @Override
    public void deleteMatricula(Matricula matricula) {
        log.info("[inicia] MatriculaInfraRepository - deleteMatricula");
        matriculaSpringDataJPARepository.delete(matricula);
        log.info("[finaliza] MatriculaInfraRepository - deleteMatricula");
    }
}
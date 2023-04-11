package com.rlti.autoescola.matricula.application.repository;

import com.rlti.autoescola.matricula.infra.MatriculaSpringDataJPARepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class MatriculaInfraRepository implements MatriculaRepository {
    private final MatriculaSpringDataJPARepository matriculaSpringDataJPARepository;

}

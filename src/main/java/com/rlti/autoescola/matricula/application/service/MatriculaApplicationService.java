package com.rlti.autoescola.matricula.application.service;

import com.rlti.autoescola.matricula.application.api.MatriculaListResponse;
import com.rlti.autoescola.matricula.application.api.MatriculaRequest;
import com.rlti.autoescola.matricula.application.api.MatriculaResponse;
import com.rlti.autoescola.matricula.application.repository.MatriculaRepository;
import com.rlti.autoescola.matricula.domain.Matricula;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class MatriculaApplicationService implements MatriculaService{
    private final MatriculaRepository matriculaRepository;

    @Override
    public MatriculaResponse criaNovaMatricula(MatriculaRequest matriculaRequest) {
        log.info("[finaliza] MatriculaApplicationService - criaNovaMatricula");
        Matricula matricula = matriculaRepository.salva(new Matricula(matriculaRequest));
        log.info("[finaliza] MatriculaApplicationService - criaNovaMatricula");
        return null;
    }

    @Override
    public List<MatriculaListResponse> buscaTodasMatriculas() {
        return null;
    }
}

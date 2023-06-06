package com.rlti.autoescola.exame.application.service;

import com.rlti.autoescola.exame.application.api.ExameIdResponse;
import com.rlti.autoescola.exame.application.api.ExameRequest;
import com.rlti.autoescola.exame.application.api.ExameResponse;
import com.rlti.autoescola.exame.application.api.ResultadoRequest;
import com.rlti.autoescola.exame.application.repository.ExameRepository;
import com.rlti.autoescola.exame.domain.Exame;
import com.rlti.autoescola.exame.domain.Resultado;
import com.rlti.autoescola.exame.domain.ValidaExame;
import com.rlti.autoescola.matricula.application.repository.MatriculaRepository;
import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.security.config.JwtService;
import com.rlti.autoescola.security.user.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class ExameApplicationService implements ExameService {
    private final ExameRepository exameRepository;
    private final MatriculaRepository matriculaRepository;
    private final JwtService jwtService;

    @Override
    public ExameIdResponse saveExame(UUID idMatricula, ExameRequest request) {
        log.info("[inicia] ExameApplicationService - saveExame");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        List<Exame> exames = exameRepository.getAllExamesByMatricula(matricula);
        ValidaExame.validaExame(exames, request);
        Exame exame = exameRepository.saveExame(new Exame(matricula, request));
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
    public List<ExameResponse> getAllExames(UUID idMatricula) {
        log.info("[inicia] ExameApplicationService - getAllExames");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        List<Exame> exames = exameRepository.getAllExamesByMatricula(matricula);
        log.info("[finaliza] ExameApplicationService - getAllExames");
        return ExameResponse.converte(exames);
    }

    @Override
    public void deleteExame(Long idExame) {
        //TODO -> criar validacao permitir exclusão de um exame que quebre a norma
        log.info("[inicia] ExameApplicationService - deleteExame");
        exameRepository.deleteExame(exameRepository.getOneExame(idExame).getIdExame());
        log.info("[finaliza] ExameApplicationService - deleteExame");
    }

    @Override
    public void updateExame(Long idExame, ResultadoRequest request) {
        log.info("[inicia] ExameApplicationService - updateExame");
        Exame exame = exameRepository.getOneExame(idExame);
        exame.altera(request);
        exameRepository.saveExame(exame);
        log.info("[finaliza] ExameApplicationService - updateExame");
    }

    @Override
    public List<ExameResponse> getAllExamesUser(String token) {
        log.info("[inicia] ExameApplicationService - getAllExamesUser");
        List<Exame> exames = new ArrayList<>();
        var user = jwtService.getUserByBearerToken(token);
        if (user.get().equals(Role.USER)) {
            Matricula matricula = matriculaRepository.getOneMatricula(UUID.fromString(user.get()));
            exames = exameRepository.getAllExamesByMatricula(matricula);
            log.info("[matricula] {}",  matricula);
        }else{
            exames = exameRepository.getAllExames();
            log.info("[all] ");
        }
        log.info("[finaliza] ExameApplicationService - getAllExamesUser");
        return ExameResponse.converte(exames);
    }
}
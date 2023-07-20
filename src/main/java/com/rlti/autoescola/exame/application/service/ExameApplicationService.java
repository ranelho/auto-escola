package com.rlti.autoescola.exame.application.service;

import com.rlti.autoescola.exame.application.api.ExameIdResponse;
import com.rlti.autoescola.exame.application.api.ExameRequest;
import com.rlti.autoescola.exame.application.api.ExameResponse;
import com.rlti.autoescola.exame.application.api.ResultadoRequest;
import com.rlti.autoescola.exame.application.repository.ExameRepository;
import com.rlti.autoescola.exame.domain.Exame;
import com.rlti.autoescola.exame.domain.Resultado;
import com.rlti.autoescola.exame.validation.ValidaDeleteExame;
import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.matricula.application.repository.MatriculaRepository;
import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.security.config.JwtService;
import com.rlti.autoescola.security.user.domain.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.rlti.autoescola.exame.application.api.ExameResponse.converte;
import static com.rlti.autoescola.exame.validation.ValidaExame.validaExame;

@Service
@RequiredArgsConstructor
@Log4j2
public class ExameApplicationService implements ExameService {
    private final ExameRepository exameRepository;
    private final MatriculaRepository matriculaRepository;
    private final JwtService jwtService;

    @Override
    public ExameIdResponse saveExame(UUID idMatricula, ExameRequest request) {
        log.info("[inicia] ExameApplicationService.saveExame");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        List<Exame> exames = exameRepository.getAllExamesByMatricula(matricula);
        validaExame(exames, request);
        Exame exame = exameRepository.saveExame(new Exame(matricula, request));
        log.info("[finaliza] ExameApplicationService.saveExame");
        return ExameIdResponse.builder().idExame(exame.getIdExame()).build();
    }

    @Override
    public ExameResponse getOneExame(Long idExame) {
        log.info("[inicia] ExameApplicationService.getOneExame");
        Exame exame = exameRepository.getOneExame(idExame);
        log.info("[finaliza] ExameApplicationService.getOneExame");
        return new ExameResponse(exame);
    }

    @Override
    public List<ExameResponse> getAllExames(UUID idMatricula) {
        log.info("[inicia] ExameApplicationService.getAllExames");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        List<Exame> exames = exameRepository.getAllExamesByMatricula(matricula);
        log.info("[finaliza] ExameApplicationService.getAllExames");
        return converte(exames);
    }

    @Override
    public void deleteExame(Long idExame) {
        log.info("[inicia] ExameApplicationService.deleteExame");
        Exame exame = exameRepository.getOneExame(idExame);
        List<Exame> exames = exameRepository.getAllExamesByMatricula(exame.getMatricula());
        ValidaDeleteExame.validaDelete(exames, exame);
        exameRepository.deleteExame(exame.getIdExame());
        log.info("[finaliza] ExameApplicationService.deleteExame");
    }

    @Override
    public void updateExame(Long idExame, ResultadoRequest request) {
        log.info("[inicia] ExameApplicationService.updateExame");
        Exame exame = exameRepository.getOneExame(idExame);
        if (!exame.getResultado().equals(Resultado.APTO)){
            exame.altera(request);
            exameRepository.saveExame(exame);
        }else {
            throw APIException.build(HttpStatus.BAD_REQUEST,"Exame finalizado!");
        }
        log.info("[finaliza] ExameApplicationService.updateExame");
    }

    @Override
    public List<ExameResponse> getAllExamesUser(String token) {
        log.info("[inicia] ExameApplicationService.getAllExamesUser");
        List<Exame> exames;
        Optional<String> user = jwtService.getUserByBearerToken(token);
        if (user.isPresent() && user.get().equals(Role.USER.name())) {
            Matricula matricula = matriculaRepository.getOneMatricula(UUID.fromString(user.get()));
            exames = exameRepository.getAllExamesByMatricula(matricula);
        } else {
            exames = exameRepository.getAllExames();
        }
        log.info("[finaliza] ExameApplicationService.getAllExamesUser");
        return converte(exames);
    }
}
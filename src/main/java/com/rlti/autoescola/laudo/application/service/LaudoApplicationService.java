package com.rlti.autoescola.laudo.application.service;

import com.rlti.autoescola.laudo.application.api.*;
import com.rlti.autoescola.laudo.application.repository.LaudoRepository;
import com.rlti.autoescola.laudo.domain.Laudo;
import com.rlti.autoescola.matricula.application.repository.MatriculaRepository;
import com.rlti.autoescola.matricula.domain.Matricula;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class LaudoApplicationService implements LaudoService {
    private final LaudoRepository laudoRepository;
    private final MatriculaRepository matriculaRepository;

    @Override
    public LaudoIdResponse postLaudo(UUID idMatricula, LaudoRequest request) {
        log.info("[inicia] LaudoApplicationService -  postLaudo");
        Matricula matricula = matriculaRepository.matriculaAtravesId(idMatricula);
        Laudo laudo = laudoRepository.salva(new Laudo(matricula, request));
        log.info("[finaliza] LaudoApplicationService -  postLaudo");
        return LaudoIdResponse.builder().idLaudo(laudo.getIdLaudo()).build();
    }

    @Override
    public LaudoResponse getLaudoById(Long idLaudo) {
        log.info("[inicia] LaudoApplicationService -  getLaudoById");
        Laudo laudo = laudoRepository.getLaudoById(idLaudo);
        log.info("[finaliza] LaudoApplicationService -  getLaudoById");
        return new LaudoResponse(laudo);
    }

    @Override
    public void update(Long idLaudo, LaudoRequest request) {
        log.info("[inicia] LaudoApplicationService -  update");
        Laudo laudo = laudoRepository.getLaudoById(idLaudo);
        laudo.altera(request);
        laudoRepository.salva(laudo);
        log.info("[finaliza] LaudoApplicationService -  update");
    }

    @Override
    public void deleta(Long idLaudo) {
        log.info("[inicia] LaudoApplicationService -  deleta");
        Laudo laudo = laudoRepository.getLaudoById(idLaudo);
        laudoRepository.deleta(laudo.getIdLaudo());
        log.info("[finaliza] LaudoApplicationService -  deleta");
    }

    @Override
    public List<LaudoResponse> getLaudoByMatricula(UUID idMatricula) {
        log.info("[inicia] LaudoApplicationService -  deleta");
        Matricula matricula = matriculaRepository.matriculaAtravesId(idMatricula);
        List<Laudo> laudos = laudoRepository.getLaudosByMatricula(matricula);
        log.info("[finaliza] LaudoApplicationService -  deleta");
        return LaudoResponse.converte(laudos);
    }
}
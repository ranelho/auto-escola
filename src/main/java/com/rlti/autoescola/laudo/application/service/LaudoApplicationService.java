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
    public LaudoIdResponse saveLaudo(UUID idMatricula, LaudoRequest request) {
        log.info("[inicia] LaudoApplicationService -  saveLaudo");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        Laudo laudo = laudoRepository.saveLaudo(new Laudo(matricula, request));
        log.info("[finaliza] LaudoApplicationService -  saveLaudo");
        return LaudoIdResponse.builder().idLaudo(laudo.getIdLaudo()).build();
    }

    @Override
    public LaudoResponse getOneLaudo(Long idLaudo) {
        log.info("[inicia] LaudoApplicationService -  getOneLaudo");
        Laudo laudo = laudoRepository.getOneLaudo(idLaudo);
        log.info("[finaliza] LaudoApplicationService -  getOneLaudo");
        return new LaudoResponse(laudo);
    }

    @Override
    public void updateLaudo(Long idLaudo, LaudoRequest request) {
        log.info("[inicia] LaudoApplicationService -  updateLaudo");
        Laudo laudo = laudoRepository.getOneLaudo(idLaudo);
        laudo.altera(request);
        laudoRepository.saveLaudo(laudo);
        log.info("[finaliza] LaudoApplicationService -  updateLaudo");
    }

    @Override
    public void deleteLaudo(Long idLaudo) {
        log.info("[inicia] LaudoApplicationService -  deleteLaudo");
        Laudo laudo = laudoRepository.getOneLaudo(idLaudo);
        laudoRepository.deleteLaudo(laudo.getIdLaudo());
        log.info("[finaliza] LaudoApplicationService -  deleteLaudo");
    }

    @Override
    public List<LaudoResponse> getAllLaudosByMatricula(UUID idMatricula) {
        log.info("[inicia] LaudoApplicationService -  getAllLaudosByMatricula");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        List<Laudo> laudos = laudoRepository.getAllLaudosByMatricula(matricula);
        log.info("[finaliza] LaudoApplicationService -  getAllLaudosByMatricula");
        return LaudoResponse.converte(laudos);
    }
}
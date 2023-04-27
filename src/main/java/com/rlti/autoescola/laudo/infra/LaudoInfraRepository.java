package com.rlti.autoescola.laudo.infra;

import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.laudo.application.repository.LaudoRepository;
import com.rlti.autoescola.laudo.domain.Laudo;
import com.rlti.autoescola.matricula.domain.Matricula;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Log4j2
public class LaudoInfraRepository implements LaudoRepository {
    private final LaudoSpringJPARespository laudoSpringJPARespository;

    @Override
    public Laudo saveLaudo(Laudo laudo) {
        log.info("[inicia] LaudoInfraRepository - saveLaudo");
        try{
            laudoSpringJPARespository.save(laudo);
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST, "RENACH já cadastrado", e);
        }
        log.info("[finaliza] LaudoInfraRepository - saveLaudo");
        return laudo;
    }

    @Override
    public void deleteLaudo(Long idLaudo) {
        log.info("[inicia] LaudoInfraRepository - deleteLaudo");
        laudoSpringJPARespository.deleteById(idLaudo);
        log.info("[finaliza] LaudoInfraRepository - deleteLaudo");
    }

    @Override
    public Laudo getOneLaudo(Long idLaudo) {
        log.info("[inicia] LaudoInfraRepository - getOneLaudo");
        Optional<Laudo> optionalLaudo = laudoSpringJPARespository.findById(idLaudo);
        Laudo laudo = optionalLaudo
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Laudo não encontrado"));
        log.info("[finaliza] LaudoInfraRepository - getOneLaudo");
        return laudo;
    }

    @Override
    public List<Laudo> getAllLaudosByMatricula(Matricula matricula) {
        log.info("[inicia] LaudoInfraRepository - getAllLaudosByMatricula");
        List<Laudo> laudos = laudoSpringJPARespository.findByMatricula(matricula);
        log.info("[finaliza] LaudoInfraRepository - getAllLaudosByMatricula");
        return laudos;
    }
}

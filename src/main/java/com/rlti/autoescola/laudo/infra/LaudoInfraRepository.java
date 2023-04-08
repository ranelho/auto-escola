package com.rlti.autoescola.laudo.infra;

import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.laudo.application.repository.LaudoRepository;
import com.rlti.autoescola.laudo.domain.Laudo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Log4j2
public class LaudoInfraRepository implements LaudoRepository {
    private final LaudoSpringJPARespository laudoSpringJPARespository;

    @Override
    public Laudo salva(Laudo laudo) {
        log.info("[inicia] LaudoInfraRepository - salva");
        try{
            laudoSpringJPARespository.save(laudo);
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST, "RENACH já cadastrado", e);
        }
        log.info("[finaliza] LaudoInfraRepository - salva");
        return laudo;
    }

    @Override
    public Laudo getById(Long idLaudo) {
        log.info("[inicia] LaudoInfraRepository - salva");
        Optional<Laudo> optionalLaudo = laudoSpringJPARespository.findById(idLaudo);
        Laudo laudo = optionalLaudo
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Laudo não encontrado"));
        log.info("[finaliza] LaudoInfraRepository - salva");
        return laudo;
    }
}

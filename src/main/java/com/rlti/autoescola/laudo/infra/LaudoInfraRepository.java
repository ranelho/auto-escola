package com.rlti.autoescola.laudo.infra;

import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.laudo.application.repository.LaudoRepository;
import com.rlti.autoescola.laudo.domain.Laudo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

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
}

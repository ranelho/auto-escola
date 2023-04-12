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
    public void deleta(Long idLaudo) {
        log.info("[inicia] LaudoInfraRepository - deleta");
        laudoSpringJPARespository.deleteById(idLaudo);
        log.info("[finaliza] LaudoInfraRepository - deleta");
    }

    @Override
    public Laudo getLaudoById(Long idLaudo) {
        log.info("[inicia] LaudoInfraRepository - getLaudoById");
        Optional<Laudo> optionalLaudo = laudoSpringJPARespository.findById(idLaudo);
        Laudo laudo = optionalLaudo
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Laudo não encontrado"));
        log.info("[finaliza] LaudoInfraRepository - getLaudoById");
        return laudo;
    }

    @Override
    public List<Laudo> getLaudosByMatricula(Matricula matricula) {
        log.info("[inicia] LaudoInfraRepository - getLaudosByMatricula");
        List<Laudo> laudos = laudoSpringJPARespository.findByMatricula(matricula);
        log.info("[finaliza] LaudoInfraRepository - getLaudosByMatricula");
        return laudos;
    }
}

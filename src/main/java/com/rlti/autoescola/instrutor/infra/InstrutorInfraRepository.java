package com.rlti.autoescola.instrutor.infra;

import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.instrutor.application.repository.InstrutorRepository;
import com.rlti.autoescola.instrutor.domain.Instrutor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class InstrutorInfraRepository implements InstrutorRepository {
    private final InstrutorSpringDataJPARepository instrutorSpringDataJPARepository;

    @Override
    public Instrutor save(Instrutor instrutor) {
        log.info("[inicia] InstrutorInfraRepository - save ");
        try{
            instrutorSpringDataJPARepository.save(instrutor);
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Instrutor já cadastrado", e);
        }
        log.info("[finaliza] InstrutorInfraRepository - save ");
        return instrutor;
    }
}

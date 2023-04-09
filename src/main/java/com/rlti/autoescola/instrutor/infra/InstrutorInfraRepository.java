package com.rlti.autoescola.instrutor.infra;

import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.instrutor.application.repository.InstrutorRepository;
import com.rlti.autoescola.instrutor.domain.Instrutor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Instrutor getInstrutor(UUID idInstrutor) {
        log.info("[inicia] InstrutorInfraRepository - getInstrutor ");
        Optional<Instrutor> optionalInstrutor = instrutorSpringDataJPARepository.findById(idInstrutor);
        Instrutor instrutor = optionalInstrutor
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Instrutor não cadastrado!"));
        log.info("[finaliza] InstrutorInfraRepository - getInstrutor ");
        return instrutor;
    }

    @Override
    public List<Instrutor> getAllInstrutors() {
        log.info("[inicia] InstrutorInfraRepository - getAllInstrutors ");
        List<Instrutor> instrutors = instrutorSpringDataJPARepository.findAll();
        log.info("[finaliza] InstrutorInfraRepository - getAllInstrutors ");
        return instrutors;
    }
}
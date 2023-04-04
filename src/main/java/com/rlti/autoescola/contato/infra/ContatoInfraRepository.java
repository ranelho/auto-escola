package com.rlti.autoescola.contato.infra;

import com.rlti.autoescola.cliente.infra.ClienteSpringDataJPARepository;
import com.rlti.autoescola.contato.application.repository.ContatoRepository;
import com.rlti.autoescola.contato.domain.Contato;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ContatoInfraRepository implements ContatoRepository {
    private final ContatoSpringDataJPARepository contatoSpringDataJPARepository;

    @Override
    public Contato salvaContato(Contato contato) {
        log.info("[inicia] ContatoInfraRepository - salvaContato");
        Contato contatoCriado = contatoSpringDataJPARepository.save(contato);
        log.info("[finaliza] ContatoInfraRepository - salvaContato");
        return contatoCriado;
    }
}

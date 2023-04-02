package com.rlti.autoescola.cliente.infra;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.Store;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ClienteInfraRepository implements ClienteRepository {

    private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

    @Override
    public Cliente salva(Cliente cliente) {
        log.info("[inicia] ClienteInfraRepository - salva");
        try{
<<<<<<< HEAD
            Cliente novoCliente = clienteSpringDataJPARepository.save(cliente);
            log.info("[finaliza] ClienteRepositoryDB - salva");
            return novoCliente;
=======
            clienteSpringDataJPARepository.save(cliente);
            log.info("[finaliza] ClienteInfraRepository - salva");
            return cliente;
>>>>>>> c6942f576049c08c83150ecdfe01a27e538fd700
        }catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Cliente já cadastrado", e);
        }
    }
}

package com.rlti.autoescola.cliente.infra;

import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.handler.APIException;
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
public class ClienteInfraRepository implements ClienteRepository {

    private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

    @Override
    public Cliente saveCliente(Cliente cliente) {
        log.info("[inicia] ClienteInfraRepository - salva");
        try{
            Cliente clienteCriado = clienteSpringDataJPARepository.save(cliente);
            log.info("[finaliza] ClienteInfraRepository - salva");
            return clienteCriado;
        }catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST,
                    "Cliente já cadastrado, CPF: " + cliente.getCpf());
        }
    }
    @Override
    public Cliente findOneCliente(UUID idCliente) {
        log.info("[inicia] ClienteInfraRepository - findById");
        Optional<Cliente> optionalCliente = clienteSpringDataJPARepository.findById(idCliente);
        Cliente cliente = optionalCliente
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,
                        "Cliente não encontrado!"));
        log.info("[finaliza] ClienteInfraRepository - findById");
        return cliente;
    }
    @Override
    public List<Cliente> getAllClientes() {
        log.info("[inicia] ClienteInfraRepository - buscaTodosClientes");
        List<Cliente> todosClientes = clienteSpringDataJPARepository.findAll();
        log.info("[finaliza] ClienteInfraRepository - buscaTodosClientes");
        return todosClientes;
    }
    @Override
    public void deleteCliente(Cliente cliente) {
        log.info("[inicia] ClienteInfraRepository - deleteCliente");
        clienteSpringDataJPARepository.delete(cliente);
        log.info("[finaliza] ClienteInfraRepository - deleteCliente");
    }
    @Override
    public Optional<Cliente> findByCpf(String cpf) {
        log.info("[inicia] ClienteInfraRepository - findByCpf");
        Optional<Cliente> clienteOptional = clienteSpringDataJPARepository.findByCpf(cpf);
        log.info("[finaliza] ClienteInfraRepository - findByCpf");
        return clienteOptional;
    }
}
package com.rlti.autoescola.cliente.infra;

import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        log.info("[inicia] ClienteInfraRepository - saveCliente");
        try{
            Cliente clienteCriado = clienteSpringDataJPARepository.save(cliente);
            log.info("[finaliza] ClienteInfraRepository - saveCliente");
            return clienteCriado;
        }catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST,"Cliente já cadastrado, CPF: " + cliente.getCpf());
        }
    }
    @Override
    public Cliente findOneCliente(UUID idCliente) {
        log.info("[inicia] ClienteInfraRepository - findOneCliente");
        Optional<Cliente> optionalCliente = clienteSpringDataJPARepository.findById(idCliente);
        Cliente cliente = optionalCliente
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,
                        "Cliente não encontrado!"));
        log.info("[finaliza] ClienteInfraRepository - findOneCliente");
        return cliente;
    }
    @Override
    public Page<Cliente> getAllClientes(Pageable pageable) {
        log.info("[inicia] ClienteInfraRepository - getAllClientes");
        Page<Cliente> todosClientes = clienteSpringDataJPARepository.findAll(pageable);
        log.info("[finaliza] ClienteInfraRepository - getAllClientes");
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

    @Override
    public List<Cliente> getAllClientesRelatorio() {
        log.info("[inicia] ClienteInfraRepository - getAllClientesRelatorio");
        List<Cliente> clientes = clienteSpringDataJPARepository.findAll();
        log.info("[finaliza] ClienteInfraRepository - getAllClientesRelatorio");
        return clientes;
    }
}
package com.rlti.autoescola.cliente.application.api;

import com.rlti.autoescola.cliente.application.service.ClienteService;
import com.rlti.autoescola.cliente.application.service.ImagemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ClienteRestController implements ClienteAPI {
    private final ClienteService clienteService;
    private final ImagemService imagemService;

    @Override
    public ClienteResponse post(ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteRestController - post");
        ClienteResponse clienteCriado = clienteService.criaNovoCliente(clienteRequest);
        log.info("[finaliza] ClienteRestController - post");
        return clienteCriado;
    }
    @Override
    public ClienteResponse findById(UUID idCliente) {
        log.info("[inicia] ClienteRestController - findById");
        ClienteResponse buscaCliente = clienteService.findById(idCliente);
        log.info("[finaliza] ClienteRestController - findById");
        return buscaCliente;
    }
    @Override
    public ClienteResponse findByCpf(String cpf) {
        log.info("[inicia] ClienteRestController - findByCpf");
        ClienteResponse buscaCPF = clienteService.findByCpf(cpf);
        log.info("[finaliza] ClienteRestController - findByCpf");
        return buscaCPF;
    }
    @Override
    public List<ClienteListResponse> getAll() {
        log.info("[inicia] ClienteRestController - buscaTodosClientes");
        List<ClienteListResponse> clientes = clienteService.buscaTodosClientes();
        log.info("[finaliza] ClienteRestController - buscaTodosClientes");
        return clientes;
    }
    @Override
    public void delete(UUID idCliente) {
        log.info("[inicia] ClienteRestController - delete");
        clienteService.delete(idCliente);
        log.info("[finaliza] ClienteRestController - delete");
    }
    @Override
    public void update(UUID idCliente, @Valid  EditaClienteRequest editaClienteRequest) {
        log.info("[inicia] ClienteRestController - update");
        clienteService.update(idCliente, editaClienteRequest);
        log.info("[idCliente] {}", idCliente);
        log.info("[finaliza] ClienteRestController - update");
    }

    @Override
    public void novaImagem(UUID idCliente, MultipartFile imagem) throws IOException {
        log.info("[inicia] ClienteRestController - editaImagem");
        imagemService.novaImagem(idCliente, imagem);
        log.info("[finaliza] ClienteRestController - editaImagem");
    }
}
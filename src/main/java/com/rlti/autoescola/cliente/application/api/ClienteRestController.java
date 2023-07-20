package com.rlti.autoescola.cliente.application.api;

import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.cliente.application.service.ClienteService;
import com.rlti.autoescola.cliente.application.service.ImagemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ClienteRestController implements ClienteAPI {
    private final ClienteService clienteService;
    private final ImagemService imagemService;
    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse saveCliente(ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteRestController - saveCliente");
        ClienteResponse response = clienteService.saveCliente(clienteRequest);
        log.info("[finaliza] ClienteRestController - saveCliente");
        return response;
    }
    @Override
    public ClienteResponse getOneCliente(UUID idCliente) {
        log.info("[inicia] ClienteRestController - getOneCliente");
        ClienteResponse response = clienteService.getOneCliente(idCliente);
        log.info("[finaliza] ClienteRestController - getOneCliente");
        return response;
    }
    @Override
    public ClienteResponse getByCpf(String cpf) {
        log.info("[inicia] ClienteRestController - getByCpf");
        ClienteResponse response = clienteService.getByCpf(cpf);
        log.info("[finaliza] ClienteRestController - getByCpf");
        return response;
    }
    @Override
    public Page<ClienteListResponse> getAllClientes(Pageable pageable) {
        log.info("[inicia] ClienteRestController - getAllClientes");
        Page<ClienteListResponse> clientes = clienteService.getAllClientes(pageable);
        log.info("[finaliza] ClienteRestController - getAllClientes");
        return clientes;
    }
    @Override
    public void updateCliente(UUID idCliente, @Valid  EditaClienteRequest editaClienteRequest) {
        log.info("[inicia] ClienteRestController - updateCliente");
        clienteService.updateCliente(idCliente, editaClienteRequest);
        log.info("[finaliza] ClienteRestController - updateCliente");
    }
    @Override
    public void saveImagem(UUID idCliente, MultipartFile imagem) throws IOException {
        log.info("[inicia] ClienteRestController - saveImagem");
        imagemService.saveImagem(idCliente, imagem);
        log.info("[finaliza] ClienteRestController - saveImagem");
    }
}
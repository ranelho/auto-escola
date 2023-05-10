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
    public ClienteResponse saveCliente(ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteRestController - saveCliente");
        ClienteResponse clienteCriado = clienteService.saveCliente(clienteRequest);
        log.info("[finaliza] ClienteRestController - saveCliente");
        return clienteCriado;
    }
    @Override
    public ClienteResponse getOneCliente(UUID idCliente) {
        log.info("[inicia] ClienteRestController - getOneCliente");
        ClienteResponse buscaCliente = clienteService.getOneCliente(idCliente);
        log.info("[finaliza] ClienteRestController - getOneCliente");
        return buscaCliente;
    }
    @Override
    public ClienteResponse getByCpf(String cpf) {
        log.info("[inicia] ClienteRestController - getByCpf");
        ClienteResponse buscaCPF = clienteService.getByCpf(cpf);
        log.info("[finaliza] ClienteRestController - getByCpf");
        return buscaCPF;
    }
    @Override
    public List<ClienteListResponse> getAllClientes() {
        log.info("[inicia] ClienteRestController - getAllClientes");
        List<ClienteListResponse> clientes = clienteService.getAllClientes();
        log.info("[finaliza] ClienteRestController - getAllClientes");
        return clientes;
    }
    @Override
    public void updateCliente(UUID idCliente, @Valid  EditaClienteRequest editaClienteRequest) {
        log.info("[inicia] ClienteRestController - updateCliente");
        clienteService.updateCliente(idCliente, editaClienteRequest);
        log.info("[idCliente] {}", idCliente);
        log.info("[finaliza] ClienteRestController - updateCliente");
    }
    @Override
    public void saveImagem(UUID idCliente, MultipartFile imagem) throws IOException {
        log.info("[inicia] ClienteRestController - saveImagem");
        imagemService.saveImagem(idCliente, imagem);
        log.info("[finaliza] ClienteRestController - saveImagem");
    }
}
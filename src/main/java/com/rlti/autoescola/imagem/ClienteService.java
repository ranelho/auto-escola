package com.rlti.autoescola.imagem;

import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.cliente.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente atualizarImagemCliente(UUID idCliente, MultipartFile imagem) throws IOException {
        Cliente cliente = clienteRepository.buscaClientePorId(idCliente);
        cliente.inserirImagem(imagem.getBytes());
        return clienteRepository.salva(cliente);
    }
}

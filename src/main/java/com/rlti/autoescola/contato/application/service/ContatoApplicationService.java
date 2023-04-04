package com.rlti.autoescola.contato.application.service;

import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.contato.application.api.ContatoRequest;
import com.rlti.autoescola.contato.application.api.ContatoResponse;
import com.rlti.autoescola.contato.application.repository.ContatoRepository;
import com.rlti.autoescola.contato.domain.Contato;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class ContatoApplicationService implements ContatoService {
    private final ClienteRepository clienteRepository;
    private final ContatoRepository contatoRepository;

    @Override
    public ContatoResponse criaNovoContato(UUID idCliente, ContatoRequest contatoRequest) {
        log.info("[inicia] ContatoApplicationService - criaNovoContato");
        Cliente cliente = clienteRepository.buscaClientePorId(idCliente);
        Contato contato = contatoRepository.salvaContato(new Contato(cliente, contatoRequest));
        log.info("[finaliza] ContatoApplicationService - criaNovoContato");
        return new ContatoResponse(contato);
    }
    @Override
    public ContatoResponse buscaContatoPorId(UUID idContato) {
        log.info("[inicia] ContatoApplicationService - buscaContatoPorId");
        Contato contato = contatoRepository.buscaContatoPorId(idContato);
        log.info("[finaliza] ContatoApplicationService - buscaContatoPorId");
        return new ContatoResponse(contato);
    }
    @Override
    public List<ContatoResponse> buscaContatosDoCliente(UUID idCliente) {
        log.info("[inicia] ContatoApplicationService - buscaContatosDoCliente");
        List<Contato> contatos = clienteRepository.buscaContatosDoCliente(idCliente);
        log.info("[finaliza] ContatoApplicationService - buscaContatosDoCliente");
        return null;
    }
}

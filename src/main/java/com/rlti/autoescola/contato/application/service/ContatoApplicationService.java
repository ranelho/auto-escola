package com.rlti.autoescola.contato.application.service;

import com.rlti.autoescola.cliente.application.api.ClienteContatosResponse;
import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.contato.application.api.ContatoRequest;
import com.rlti.autoescola.contato.application.api.ContatoResponse;
import com.rlti.autoescola.contato.application.repository.ContatoRepository;
import com.rlti.autoescola.contato.domain.Contato;
import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.orcamento.application.api.OrcamentoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class ContatoApplicationService implements ContatoService {
    private final ClienteRepository clienteRepository;
    private final ContatoRepository contatoRepository;

    @Override
    public ContatoResponse saveContato(UUID idCliente, ContatoRequest contatoRequest) {
        log.info("[inicia] ContatoApplicationService - saveContato");
        Cliente cliente = clienteRepository.findOneCliente(idCliente);
        VerificaContato(cliente, contatoRequest);
        Contato contato = contatoRepository.saveContato(new Contato(cliente, contatoRequest));
        log.info("[finaliza] ContatoApplicationService - saveContato");
        return new ContatoResponse(contato);
    }

    private void VerificaContato(Cliente cliente, ContatoRequest contatoRequest) {
        log.info("[Inicia] ContatoApplicationService - VerificaContato");
        List<Contato> contatos = cliente.getContatos();
        for (Contato contato : contatos) {
            if (contato.getTelefone().equals(contatoRequest.getTelefone())) {
                throw APIException.build(HttpStatus.BAD_REQUEST, "Telefone ja Cadastrado");
            } else if (contato.getPadrao() && contatoRequest.getPadrao()) {
                contato.alteraPadrao();
                contatoRepository.saveContato(contato);
            }
        }
        log.info("[Finaliza] ContatoApplicationService - VerificaContato");
    }

    @Override
    public ContatoResponse getOneContato(UUID idContato) {
        log.info("[inicia] ContatoApplicationService - getOneContato");
        Contato contato = contatoRepository.getOneContato(idContato);
        log.info("[finaliza] ContatoApplicationService - getOneContato");
        return new ContatoResponse(contato);
    }
    @Override
    public ClienteContatosResponse getAllContatosCliente(UUID idCliente) {
        log.info("[inicia] ContatoApplicationService - getAllContatosCliente");
        Cliente cliente = clienteRepository.findOneCliente(idCliente);
        log.info("[finaliza] ContatoApplicationService - getAllContatosCliente");
        return new ClienteContatosResponse(cliente);
    }
    @Override
    public void deleteContato(UUID idContato) {
        log.info("[inicia] ContatoApplicationService - deleteContato");
        contatoRepository.deleteContato(contatoRepository.getOneContato(idContato).getIdContato());
        log.info("[finaliza] ContatoApplicationService - deleteContato");
    }
    @Override
    public void updateContato(UUID idContato, ContatoRequest contatoRequest) {
        log.info("[inicia] ContatoApplicationService - updateContato");
        Contato contato = contatoRepository.getOneContato(idContato);
        contato.altera(contatoRequest);
        contatoRepository.saveContato(contato);
        log.info("[finaliza] ContatoApplicationService - updateContato");
    }

    @Override
    public void getOrcamentoByCliente(Cliente cliente, OrcamentoRequest orcamentoRequest) {
        log.info("[inicia] ContatoApplicationService - getOrcamentoByCliente");
        Optional<Contato> contatos = contatoRepository.getContatoByTelefone(orcamentoRequest.getTelefone());
        if(contatos.isEmpty() || contatos.get().getCliente().getIdCliente() != cliente.getIdCliente()){
            contatoRepository.saveContato(new Contato(cliente, orcamentoRequest));
        }
        log.info("[finaliza] ContatoApplicationService - getOrcamentoByCliente");
    }
}

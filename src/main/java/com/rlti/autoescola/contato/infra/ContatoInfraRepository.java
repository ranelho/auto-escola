package com.rlti.autoescola.contato.infra;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.contato.application.repository.ContatoRepository;
import com.rlti.autoescola.contato.domain.Contato;
import com.rlti.autoescola.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ContatoInfraRepository implements ContatoRepository {
    private final ContatoSpringDataJPARepository contatoSpringDataJPARepository;

    @Override
    public Contato saveContato(Contato contato) {
        log.info("[inicia] ContatoInfraRepository - saveContato");
        Contato contatoCriado = contatoSpringDataJPARepository.save(contato);
        log.info("[finaliza] ContatoInfraRepository - saveContato");
        return contatoCriado;
    }
    @Override
    public Contato getOneContato(UUID idContato) {
        log.info("[inicia] ContatoInfraRepository - getOneContato");
        Optional<Contato> optionalContato = contatoSpringDataJPARepository.findById(idContato);
        Contato contato = optionalContato
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,
                "Contato do Cliente não encontrado!"));
        log.info("[finaliza] ContatoInfraRepository - getOneContato");
        return contato;
    }
    @Override
    public List<Contato> getAllContatosByCliente(Cliente cliente) {
        log.info("[inicia] ContatoInfraRepository - getAllContatosByCliente");
        List<Contato> contatos = contatoSpringDataJPARepository.findAllByCliente(cliente);
        log.info("[finaliza] ContatoInfraRepository - getAllContatosByCliente");
        return contatos;
    }
    @Override
    public void deleteContato(UUID idContato) {
        log.info("[inicia] ContatoInfraRepository - deleteContato");
        contatoSpringDataJPARepository.deleteById(idContato);
        log.info("[finaliza] ContatoInfraRepository - deleteContato");
    }
    @Override
    public Optional<Contato> getContatoByTelefone(String telefone) {
        log.info("[inicia] ContatoInfraRepository - getContatoByTelefone");
        Optional<Contato> optionalContato = contatoSpringDataJPARepository.findByTelefone(telefone);
        log.info("[finaliza] ContatoInfraRepository - getContatoByTelefone");
        return optionalContato;
    }
}
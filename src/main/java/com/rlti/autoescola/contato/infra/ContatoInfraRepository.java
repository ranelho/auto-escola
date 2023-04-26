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
        log.info("[inicia] ContatoInfraRepository - salvaContato");
        Contato contatoCriado = contatoSpringDataJPARepository.save(contato);
        log.info("[finaliza] ContatoInfraRepository - salvaContato");
        return contatoCriado;
    }
    @Override
    public Contato findById(UUID idContato) {
        log.info("[inicia] ContatoInfraRepository - findById");
        Optional<Contato> optionalContato = contatoSpringDataJPARepository.findById(idContato);
        Contato contato = optionalContato
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,
                "Contato do Cliente não encontrado!"));
        log.info("[finaliza] ContatoInfraRepository - findById");
        return contato;
    }
    @Override
    public List<Contato> buscaContatosDoCliente(Cliente cliente) {
        log.info("[inicia] ContatoInfraRepository - buscaContatosDoCliente");
        List<Contato> contatos = contatoSpringDataJPARepository.findAllByCliente(cliente);
        log.info("[finaliza] ContatoInfraRepository - buscaContatosDoCliente");
        return contatos;
    }
    @Override
    public void deleteContato(UUID idContato) {
        log.info("[inicia] ContatoInfraRepository - deleteContato");
        contatoSpringDataJPARepository.deleteById(idContato);
        log.info("[finaliza] ContatoInfraRepository - deleteContato");
    }
    @Override
    public Optional<Contato> findTelefoneContato(String telefone) {
        log.info("[inicia] ContatoInfraRepository - findTelefoneContato");
        Optional<Contato> optionalContato = contatoSpringDataJPARepository.findByTelefone(telefone);
        log.info("[finaliza] ContatoInfraRepository - findTelefoneContato");
        return optionalContato;
    }
}
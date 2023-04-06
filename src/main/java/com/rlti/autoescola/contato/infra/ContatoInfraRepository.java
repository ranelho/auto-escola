package com.rlti.autoescola.contato.infra;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.cliente.infra.ClienteSpringDataJPARepository;
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
    public Contato salvaContato(Contato contato) {
        log.info("[inicia] ContatoInfraRepository - salvaContato");
        Contato contatoCriado = contatoSpringDataJPARepository.save(contato);
        log.info("[finaliza] ContatoInfraRepository - salvaContato");
        return contatoCriado;
    }
    @Override
    public Contato buscaContatoPorId(UUID idContato) {
        log.info("[inicia] ContatoInfraRepository - buscaContatoPorId");
        Optional<Contato> optionalContato = contatoSpringDataJPARepository.findById(idContato);
        Contato contato = optionalContato
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,
                "Contato do Cliente não encontrado!"));
        log.info("[finaliza] ContatoInfraRepository - buscaContatoPorId");
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
    public void deletaContato(Contato contato) {
        log.info("[inicia] ContatoInfraRepository - deletaContato");
        contatoSpringDataJPARepository.delete(contato);
        log.info("[finaliza] ContatoInfraRepository - deletaContato");
    }
}

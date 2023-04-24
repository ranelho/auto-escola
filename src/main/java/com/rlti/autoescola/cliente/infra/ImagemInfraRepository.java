package com.rlti.autoescola.cliente.infra;

import com.rlti.autoescola.cliente.application.repository.ImagemRepository;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.cliente.domain.Imagem;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ImagemInfraRepository implements ImagemRepository {
    private final ImagemSpringDataJPARepository imagemSpringDataJPARepository;

    @Override
    public void delete(Long id) {
        log.info("[inicia] ImagemInfraRepository - delete");
        imagemSpringDataJPARepository.deleteById(id);
        log.info("[finaliza] ImagemInfraRepository - delete");
    }

    @Override
    public Imagem salva(Imagem image) {
        log.info("[inicia] ImagemInfraRepository - salva");
        imagemSpringDataJPARepository.save(image);
        log.info("[inicia] ImagemInfraRepository - salva");
        return image;
    }

    @Override
    public Optional<Imagem> findByCliente(Cliente cliente) {
        log.info("[inicia] ImagemInfraRepository - findByCliente");
        Optional<Imagem> optionalImagem = imagemSpringDataJPARepository.findByCliente(cliente);
        log.info("[finaliza] ImagemInfraRepository - findByCliente");
        return optionalImagem;
    }
}

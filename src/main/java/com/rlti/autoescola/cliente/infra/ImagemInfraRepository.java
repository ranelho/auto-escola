package com.rlti.autoescola.cliente.infra;

import com.rlti.autoescola.cliente.application.repository.ImagemRepository;
import com.rlti.autoescola.cliente.domain.Imagem;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ImagemInfraRepository implements ImagemRepository {
    private final ImagemSpringDataJPARepository imagemSpringDataJPARepository;

    @Override
    public void deleta(Long id) {
        log.info("[inicia] ImagemInfraRepository - deleta");
        log.info("id, {}", id);
        imagemSpringDataJPARepository.deleteById(id);
        log.info("[finaliza] ImagemInfraRepository - deleta");
    }

    @Override
    public void salva(Imagem image) {
        log.info("[inicia] ImagemInfraRepository - salva");
        imagemSpringDataJPARepository.save(image);
        log.info("[inicia] ImagemInfraRepository - salva");
    }
}

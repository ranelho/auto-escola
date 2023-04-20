package com.rlti.autoescola.cliente.infra;

import com.rlti.autoescola.cliente.application.repository.FotoRepository;
import com.rlti.autoescola.cliente.domain.Foto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class FotoInfraRepository implements FotoRepository {
    private final FotoSpringDataJPARepository fotoSpringDataJPARepository;

    @Override
    public void salva(Foto foto) {
        log.info("[inicia] FotoInfraRepository - salva");
        fotoSpringDataJPARepository.save(foto);
        log.info("[finaliza] FotoInfraRepository - salva");
    }
}

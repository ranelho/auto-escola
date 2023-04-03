package com.rlti.autoescola.empresa.infra;

import com.rlti.autoescola.empresa.application.repository.EmpresaRepository;
import com.rlti.autoescola.empresa.domain.Empresa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class EmpresaInfraRepository implements EmpresaRepository {
    private final EmpresaSpringDataJPARepository empresaSpringDataJPARepository;
    @Override
    public Empresa salva(Empresa empresa) {
        log.info("[inicia] EmpresaInfraRepository - salva");
        empresaSpringDataJPARepository.save(empresa);
        log.info("[finaliza] EmpresaInfraRepository - salva");
        return empresa;
    }
}

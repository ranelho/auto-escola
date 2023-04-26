package com.rlti.autoescola.empresa.infra;

import com.rlti.autoescola.empresa.application.repository.EmpresaRepository;
import com.rlti.autoescola.empresa.domain.Empresa;
import com.rlti.autoescola.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
@Log4j2
@RequiredArgsConstructor
public class EmpresaInfraRepository implements EmpresaRepository {
    private final EmpresaSpringDataJPARepository empresaSpringDataJPARepository;
    @Override
    public Empresa saveEmpresa(Empresa empresa) {
        log.info("[inicia] EmpresaInfraRepository - salva");
        try {
            empresaSpringDataJPARepository.save(empresa);
        } catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Existem dados duplicados", e);
        }
        log.info("[finaliza] EmpresaInfraRepository - salva");
        return empresa;
    }
    @Override
    public List<Empresa> getAllEmpresas() {
        log.info("[inicia] EmpresaInfraRepository - buscaTodasEmpresas");
        List<Empresa> todasEmpresas = empresaSpringDataJPARepository.findAll();
        log.info("[finaliza] EmpresaInfraRepository - buscaTodasEmpresas");
        return todasEmpresas;
    }
    @Override
    public Empresa getOneEmpresa(UUID idEmpresa) {
        log.info("[inicia] EmpresaInfraRepository - buscaEmpresaAtravesId");
        Empresa empresa = empresaSpringDataJPARepository.findById(idEmpresa)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Empresa não encontrado"));
        log.info("[finaliza] EmpresaInfraRepository - buscaEmpresaAtravesId");
        return empresa;
    }
    @Override
    public Empresa getAllEmpresaByCnpj(String cnpj) {
        log.info("[inicia] EmpresaInfraRepository - buscaEmpresaAtravesCnpj");
        Optional<Empresa> empresaOptional = empresaSpringDataJPARepository.findByCnpj(cnpj);
        Empresa empresa = empresaOptional.orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,
                "Empresa não encontrada!"));
        log.info("[finaliza] EmpresaInfraRepository - buscaEmpresaAtravesCnpj");
        return empresa;
    }
    @Override
    public void deleteEmpresa(UUID idEmpresa) {
        log.info("[inicia] EmpresaInfraRepository - deleteEmpresa");
        empresaSpringDataJPARepository.deleteById(idEmpresa);
        log.info("[finaliza] EmpresaInfraRepository - deleteEmpresa");
    }
}
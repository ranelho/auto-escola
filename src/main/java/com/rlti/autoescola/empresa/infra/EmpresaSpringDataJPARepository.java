package com.rlti.autoescola.empresa.infra;

import com.rlti.autoescola.empresa.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmpresaSpringDataJPARepository extends JpaRepository<Empresa, UUID> {
   Optional<Empresa> findByIdEmpresa(UUID idEmpresa);
}

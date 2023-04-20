package com.rlti.autoescola.cliente.infra;

import com.rlti.autoescola.cliente.domain.Foto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FotoSpringDataJPARepository extends JpaRepository<Foto, Long> {
}

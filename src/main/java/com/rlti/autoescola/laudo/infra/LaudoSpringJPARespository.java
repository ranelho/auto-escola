package com.rlti.autoescola.laudo.infra;

import com.rlti.autoescola.laudo.domain.Laudo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaudoSpringJPARespository extends JpaRepository<Laudo, Long> {
}

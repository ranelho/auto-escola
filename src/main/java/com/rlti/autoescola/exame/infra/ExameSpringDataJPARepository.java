package com.rlti.autoescola.exame.infra;

import com.rlti.autoescola.exame.domain.Exame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExameSpringDataJPARepository extends JpaRepository<Exame, Long> {
}

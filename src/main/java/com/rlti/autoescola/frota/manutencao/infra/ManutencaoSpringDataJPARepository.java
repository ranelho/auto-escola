package com.rlti.autoescola.frota.manutencao.infra;

import com.rlti.autoescola.frota.manutencao.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManutencaoSpringDataJPARepository extends JpaRepository<Manutencao, Long> {
}

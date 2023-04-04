package com.rlti.autoescola.frota.manutencao.infra;

import com.rlti.autoescola.frota.manutencao.Manutencao;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManutencaoSpringDataJPARepository extends JpaRepository<Manutencao, Long> {
    List<Manutencao> findAllByVeiculo(Veiculo veiculo);
}

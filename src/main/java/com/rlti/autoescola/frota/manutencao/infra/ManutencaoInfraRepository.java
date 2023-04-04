package com.rlti.autoescola.frota.manutencao.infra;

import com.rlti.autoescola.frota.manutencao.application.repository.ManutencaoRepository;
import com.rlti.autoescola.frota.manutencao.Manutencao;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import com.rlti.autoescola.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ManutencaoInfraRepository implements ManutencaoRepository {
    private final ManutencaoSpringDataJPARepository manutencaoSpringDataJPARepository;
    @Override
    public Manutencao salva(Manutencao manutencao) {
        log.info("[inicia] ManutencaoInfraRepository - salva");
        manutencaoSpringDataJPARepository.save(manutencao);
        log.info("[finaliza] ManutencaoInfraRepository - salva");
        return manutencao;
    }

    @Override
    public List<Manutencao> findAll(Veiculo veiculo) {
        log.info("[inicia] ManutencaoInfraRepository - findAll");
        List<Manutencao> manutencoes = manutencaoSpringDataJPARepository.findAllByVeiculo(veiculo);
        log.info("[finaliza] ManutencaoInfraRepository - findAll");
        return manutencoes;
    }

    @Override
    public Manutencao buscaPorId(Long idManutencao) {
        log.info("[inicia] ManutencaoInfraRepository - buscaPorId");
        Optional<Manutencao> optionalManutencao = manutencaoSpringDataJPARepository.findById(idManutencao);
        Manutencao manutencao = optionalManutencao
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Manutenção não encontrado"));
        log.info("[finaliza] ManutencaoInfraRepository - buscaPorId");
        return manutencao;
    }
}

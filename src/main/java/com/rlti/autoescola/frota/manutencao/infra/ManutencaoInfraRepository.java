package com.rlti.autoescola.frota.manutencao.infra;

import com.rlti.autoescola.frota.manutencao.application.repository.ManutencaoRepository;
import com.rlti.autoescola.frota.manutencao.domain.Manutencao;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import com.rlti.autoescola.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ManutencaoInfraRepository implements ManutencaoRepository {
    private final ManutencaoSpringDataJPARepository manutencaoSpringDataJPARepository;

    @Override
    public Manutencao saveManutencao(Manutencao manutencao) {
        log.info("[inicia] ManutencaoInfraRepository - saveManutencao");
        manutencaoSpringDataJPARepository.save(manutencao);
        log.info("[finaliza] ManutencaoInfraRepository - saveManutencao");
        return manutencao;
    }

    @Override
    public List<Manutencao> getAllManutencoes(Veiculo veiculo) {
        log.info("[inicia] ManutencaoInfraRepository - getAllManutencoes");
        List<Manutencao> manutencoes = manutencaoSpringDataJPARepository.findAllByVeiculo(veiculo);
        log.info("[finaliza] ManutencaoInfraRepository - getAllManutencoes");
        return manutencoes;
    }

    @Override
    public Manutencao getOneManutencao(Long idManutencao) {
        log.info("[inicia] ManutencaoInfraRepository - getOneManutencao");
        Optional<Manutencao> optionalManutencao = manutencaoSpringDataJPARepository.findById(idManutencao);
        Manutencao manutencao = optionalManutencao
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Manutenção não encontrado"));
        log.info("[finaliza] ManutencaoInfraRepository - getOneManutencao");
        return manutencao;
    }

    @Override
    public void deleteManutencao(Long idManutencao) {
        log.info("[inicia] ManutencaoInfraRepository - deleteManutencao");
        manutencaoSpringDataJPARepository.deleteById(idManutencao);
        log.info("[finaliza] ManutencaoInfraRepository - deleteManutencao");
    }

    @Override
    public List<Manutencao> getAllManutencoesByData(LocalDate data) {
        log.info("[inicia] ManutencaoInfraRepository - getAllManutencoesByData");
        List<Manutencao> manutencaos = manutencaoSpringDataJPARepository.findByDataManutencao(data);
        log.info("[finaliza] ManutencaoInfraRepository - getAllManutencoesByData");
        return manutencaos;
    }
}

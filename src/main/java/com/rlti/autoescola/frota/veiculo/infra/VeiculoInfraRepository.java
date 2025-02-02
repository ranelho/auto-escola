package com.rlti.autoescola.frota.veiculo.infra;

import com.rlti.autoescola.frota.veiculo.application.repository.VeiculoRepository;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import com.rlti.autoescola.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
@Log4j2
public class VeiculoInfraRepository implements VeiculoRepository {
    private final VeiculoSpringDataInfraRepository veiculoSpringDataJPARepository;

    @Override
    public Veiculo saveVeiculo(Veiculo veiculo) {
        log.info("[inicia] VeiculoInfraRepository - saveVeiculo");
        try {
            veiculoSpringDataJPARepository.save(veiculo);
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Veiculo já cadastrado" + veiculo.getPlaca());
        }
        log.info("[finaliza] VeiculoInfraRepository - saveVeiculo");
        return veiculo;
    }

    @Override
    public Veiculo getByPlaca(String placa) {
        log.info("[inicia] VeiculoInfraRepository - getByPlaca");
        Optional<Veiculo> optionalVeiculo = veiculoSpringDataJPARepository.findByPlaca(placa.toUpperCase());
        Veiculo veiculo = optionalVeiculo
                .orElseThrow(
                        () -> APIException.build(HttpStatus.BAD_REQUEST, "Veiculo não encontrado")
                );
        log.info("[finaliza] VeiculoInfraRepository - getByPlaca");
        return veiculo;
    }

    @Override
    public List<Veiculo> getAllVeiculo() {
        log.info("[inicia] VeiculoInfraRepository - getAllVeiculo");
        List<Veiculo> list = veiculoSpringDataJPARepository.findAll();
        log.info("[finaliza] VeiculoInfraRepository - getAllVeiculo");
        return list;
    }
}
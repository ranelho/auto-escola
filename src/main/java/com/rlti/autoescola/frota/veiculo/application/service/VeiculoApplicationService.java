package com.rlti.autoescola.frota.veiculo.application.service;

import com.rlti.autoescola.frota.veiculo.application.api.VeiculoIdResponse;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import com.rlti.autoescola.frota.veiculo.application.api.VeiculoRequest;
import com.rlti.autoescola.frota.veiculo.application.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Service
public class VeiculoApplicationService implements VeiculoService {
    private final VeiculoRepository veiculoRepository;

    @Override
    public VeiculoIdResponse saveVeiculo(VeiculoRequest request) {
        log.info("[inicia] VeiculoApplicationService - saveVeiculo");
        Veiculo veiculo = veiculoRepository.saveVeiculo(new Veiculo(request));
        log.info("[finaliza] VeiculoApplicationService - saveVeiculo");
        return VeiculoIdResponse.builder().idVeiculo(veiculo.getIdVeiculo()).build();
    }

    @Override
    public Veiculo getOneVeiculoByPlaca(String placa) {
        log.info("[inicia] VeiculoApplicationService - getOneVeiculoByPlaca");
        Veiculo veiculo = veiculoRepository.getByPlaca(placa);
        log.info("[finaliza] VeiculoApplicationService - getOneVeiculoByPlaca");
        return veiculo;
    }

    @Override
    public List<Veiculo> getAllVeiculos() {
        log.info("[inicia] VeiculoApplicationService - getAllVeiculos");
        List<Veiculo> veiculo = veiculoRepository.getAllVeiculo();
        log.info("[finaliza] VeiculoApplicationService - getAllVeiculos");
        return veiculo;
    }

    @Override
    public void updateVeiculo(String placa, VeiculoRequest request) {
        log.info("[inicia] VeiculoApplicationService - updateVeiculo");
        Veiculo veiculo = veiculoRepository.getByPlaca(placa);
        veiculo.altera(request);
        veiculoRepository.saveVeiculo(veiculo);
        log.info("[finaliza] VeiculoApplicationService - updateVeiculo");
    }

    @Override
    public void inativaVeiculo(String placa) {
        log.info("[inicia] VeiculoApplicationService - inativaVeiculo");
        Veiculo veiculo = veiculoRepository.getByPlaca(placa.toUpperCase());
        veiculo.inativa();
        veiculoRepository.saveVeiculo(veiculo);
        log.info("[finaliza] VeiculoApplicationService - inativaVeiculo");
    }
}
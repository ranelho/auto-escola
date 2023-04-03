package com.rlti.autoescola.frota.application.service;

import com.rlti.autoescola.frota.application.api.VeiculoIdResponse;
import com.rlti.autoescola.frota.application.api.VeiculoRequest;
import com.rlti.autoescola.frota.application.repository.VeiculoRepository;
import com.rlti.autoescola.frota.domain.Veiculo;
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
        Veiculo veiculo = veiculoRepository.salva(new Veiculo(request));
        log.info("[finaliza] VeiculoApplicationService - saveVeiculo");
        return VeiculoIdResponse.builder().idVeiculo(veiculo.getIdVeiculo()).build();
    }

    @Override
    public Veiculo getByPlaca(String placa) {
        log.info("[inicia] VeiculoApplicationService - getByPlaca");
        Veiculo veiculo = veiculoRepository.getByPlaca(placa);
        log.info("[finaliza] VeiculoApplicationService - getByPlaca");
        return veiculo;
    }

    @Override
    public List<Veiculo> getAll() {
        log.info("[inicia] VeiculoApplicationService - getAll");
        List<Veiculo> veiculo = veiculoRepository.getAll();
        log.info("[finaliza] VeiculoApplicationService - getAll");
        return veiculo;
    }

    @Override
    public void alteraVeiculo(String placa, VeiculoRequest request) {
        log.info("[inicia] VeiculoApplicationService - alteraVeiculo");
        Veiculo veiculo = veiculoRepository.getByPlaca(placa);
        veiculo.altera(request);
        veiculoRepository.salva(veiculo);
        log.info("[finaliza] VeiculoApplicationService - alteraVeiculo");
    }

    @Override
    public void deletaVeiculo(String placa) {
        log.info("[inicia] VeiculoApplicationService - alteraVeiculo");
        Veiculo veiculo = veiculoRepository.getByPlaca(placa.toUpperCase());
        veiculoRepository.deleta(veiculo.getIdVeiculo());
        log.info("[finaliza] VeiculoApplicationService - alteraVeiculo");
    }
}
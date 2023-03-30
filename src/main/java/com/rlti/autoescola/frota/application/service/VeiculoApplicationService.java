package com.rlti.autoescola.frota.application.service;

import com.rlti.autoescola.frota.application.api.VeiculoIdResponse;
import com.rlti.autoescola.frota.application.api.VeiculoRequest;
import com.rlti.autoescola.frota.application.repository.VeiculoRepository;
import com.rlti.autoescola.frota.domain.Veiculo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
    public Veiculo getAll() {
        return null;
    }
}

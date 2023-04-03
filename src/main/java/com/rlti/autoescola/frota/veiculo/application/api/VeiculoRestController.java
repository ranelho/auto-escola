package com.rlti.autoescola.frota.veiculo.application.api;

import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import com.rlti.autoescola.frota.veiculo.application.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@Log4j2
public class VeiculoRestController implements VeiculoApi {
    private final VeiculoService veiculoService;

    @Override
    public VeiculoIdResponse saveFrota(VeiculoRequest request) {
        log.info("[inicia] FrotaRestController - saveFrota");
        VeiculoIdResponse idResponse = veiculoService.saveVeiculo(request);
        log.info("[finaliza] FrotaRestController - saveFrota");
        return idResponse;
    }

    @Override
    public VeiculoResponse getByPlaca(String placa) {
        log.info("[inicia] FrotaRestController - getByPlaca");
        Veiculo veiculo = veiculoService.getByPlaca(placa);
        log.info("[finaliza] FrotaRestController - getByPlaca");
        return new VeiculoResponse(veiculo);
    }

    @Override
    public List<VeiculoResponse> getAll() {
        log.info("[inicia] FrotaRestController - getAll");
        List<Veiculo> veiculo = veiculoService.getAll();
        log.info("[finaliza] FrotaRestController - getAll");
        return VeiculoResponse.converte(veiculo);
    }

    @Override
    public void alteraVeiculo(String placa, VeiculoRequest request) {
        log.info("[inicia] FrotaRestController - alteraVeiculo");
        veiculoService.alteraVeiculo(placa, request);
        log.info("[finaliza] FrotaRestController - alteraVeiculo");
    }

    @Override
    public void deleteVeiculo(String placa) {
        log.info("[inicia] FrotaRestController - deleteVeiculo");
        veiculoService.deletaVeiculo(placa);
        log.info("[finaliza] FrotaRestController - deleteVeiculo");
    }
}
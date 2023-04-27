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
    public VeiculoIdResponse saveVeiculo(VeiculoRequest request) {
        log.info("[inicia] FrotaRestController - saveVeiculo");
        VeiculoIdResponse idResponse = veiculoService.saveVeiculo(request);
        log.info("[finaliza] FrotaRestController - saveVeiculo");
        return idResponse;
    }

    @Override
    public VeiculoResponse getOneVeiculoByPlaca(String placa) {
        log.info("[inicia] FrotaRestController - getOneVeiculoByPlaca");
        Veiculo veiculo = veiculoService.getOneVeiculoByPlaca(placa);
        log.info("[finaliza] FrotaRestController - getOneVeiculoByPlaca");
        return new VeiculoResponse(veiculo);
    }

    @Override
    public List<VeiculoResponse> getAllVeiculos() {
        log.info("[inicia] FrotaRestController - getAllVeiculos");
        List<Veiculo> veiculo = veiculoService.getAllVeiculos();
        log.info("[finaliza] FrotaRestController - getAllVeiculos");
        return VeiculoResponse.converte(veiculo);
    }

    @Override
    public void updateVeiculo(String placa, VeiculoRequest request) {
        log.info("[inicia] FrotaRestController - updateVeiculo");
        veiculoService.updateVeiculo(placa, request);
        log.info("[finaliza] FrotaRestController - updateVeiculo");
    }

    @Override
    public void inativaVeiculo(String placa) {
        log.info("[inicia] FrotaRestController - jakartaVeiculo");
        veiculoService.inativaVeiculo(placa);
        log.info("[finaliza] FrotaRestController - inativaVeiculo");
    }
}
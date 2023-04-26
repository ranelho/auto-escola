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
        log.info("[inicia] FrotaRestController - post");
        VeiculoIdResponse idResponse = veiculoService.saveVeiculo(request);
        log.info("[finaliza] FrotaRestController - post");
        return idResponse;
    }

    @Override
    public VeiculoResponse getOneVeiculoByPlaca(String placa) {
        log.info("[inicia] FrotaRestController - getByPlaca");
        Veiculo veiculo = veiculoService.getOneVeiculoByPlaca(placa);
        log.info("[finaliza] FrotaRestController - getByPlaca");
        return new VeiculoResponse(veiculo);
    }

    @Override
    public List<VeiculoResponse> getAllVeiculos() {
        log.info("[inicia] FrotaRestController - getAll");
        List<Veiculo> veiculo = veiculoService.getAll();
        log.info("[finaliza] FrotaRestController - getAll");
        return VeiculoResponse.converte(veiculo);
    }

    @Override
    public void updateVeiculo(String placa, VeiculoRequest request) {
        log.info("[inicia] FrotaRestController - update");
        veiculoService.update(placa, request);
        log.info("[finaliza] FrotaRestController - update");
    }

    @Override
    public void deleteVeiculo(String placa) {
        log.info("[inicia] FrotaRestController - delete");
        veiculoService.delete(placa);
        log.info("[finaliza] FrotaRestController - delete");
    }
}

package com.rlti.autoescola.frota.manutencao.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/manutencao")
public interface ManutencaoApi {

    @PostMapping("/{placa}")
    @ResponseStatus(code = HttpStatus.CREATED)
    ManutencaoIdResponse novaManutencao(@PathVariable String placa, @Valid @RequestBody ManutencaoRequest request);

    @GetMapping("/veiculo/{placa}")
    @ResponseStatus(code = HttpStatus.OK)
    VeiculoManutencaoResponse getManutencoesVeiculo(@PathVariable String placa);
}

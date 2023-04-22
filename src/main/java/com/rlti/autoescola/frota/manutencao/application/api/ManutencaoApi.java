package com.rlti.autoescola.frota.manutencao.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/v1/manutencao")
public interface ManutencaoApi {

    @PostMapping("/{placa}")
    @ResponseStatus(code = HttpStatus.CREATED)
    ManutencaoIdResponse post(@PathVariable String placa, @Valid @RequestBody ManutencaoRequest request);

    @GetMapping("/veiculo/{placa}")
    @ResponseStatus(code = HttpStatus.OK)
    VeiculoManutencaoResponse getByVeiculo(@PathVariable String placa);

    @GetMapping("/all/{placa}")
    @ResponseStatus(code = HttpStatus.OK)
    List<ManutencaoListResponse> getByVeiculoVeiculo(@PathVariable String placa);

    @GetMapping("{idManutencao}")
    @ResponseStatus(code = HttpStatus.OK)
    ManutencaoResponse getById(@PathVariable Long idManutencao);

    @PutMapping("{idManutencao}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void update(@PathVariable Long idManutencao, @Valid @RequestBody ManutencaoRequest request);

    @DeleteMapping("{idManutencao}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long idManutencao);
}

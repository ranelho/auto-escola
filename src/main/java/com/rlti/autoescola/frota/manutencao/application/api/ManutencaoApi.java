package com.rlti.autoescola.frota.manutencao.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/v1/manutencao")
public interface ManutencaoApi {

    @PostMapping("/{placa}")
    @ResponseStatus(code = HttpStatus.CREATED)
    ManutencaoIdResponse novaManutencao(@PathVariable String placa, @Valid @RequestBody ManutencaoRequest request);

    @GetMapping("/veiculo/{placa}")
    @ResponseStatus(code = HttpStatus.OK)
    VeiculoManutencaoResponse buscaManutencoes(@PathVariable String placa);

    @GetMapping("/all/{placa}")
    @ResponseStatus(code = HttpStatus.OK)
    List<ManutencaoListResponse> buscaManutencoesVeiculo(@PathVariable String placa);

    @GetMapping("{idManutencao}")
    @ResponseStatus(code = HttpStatus.OK)
    ManutencaoResponse buscaPorId(@PathVariable Long idManutencao);

    @PutMapping("{idManutencao}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alteraManutencao(@PathVariable Long idManutencao, @Valid @RequestBody ManutencaoRequest request);

    @DeleteMapping("{idManutencao}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteManutencao(@PathVariable Long idManutencao);
}

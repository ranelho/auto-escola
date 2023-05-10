package com.rlti.autoescola.frota.manutencao.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Tag(name = "Manutencao", description = "Manutencao APIs")
@RequestMapping("/v1/manutencoes")
public interface ManutencaoApi {

    @PostMapping("/{placa}")
    @ResponseStatus(code = HttpStatus.CREATED)
    ManutencaoIdResponse saveManutencao(@PathVariable String placa, @Valid @RequestBody ManutencaoRequest request);

    @GetMapping("/veiculo/{placa}")
    @ResponseStatus(code = HttpStatus.OK)
    VeiculoManutencaoResponse getByVeiculo(@PathVariable String placa);

    @GetMapping("/all/{placa}")
    @ResponseStatus(code = HttpStatus.OK)
    List<ManutencaoListResponse> getManutencaoByVeiculo(@PathVariable String placa);

    @GetMapping("{idManutencao}")
    @ResponseStatus(code = HttpStatus.OK)
    ManutencaoResponse getOneManutencao(@PathVariable Long idManutencao);

    @PutMapping("{idManutencao}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void updateManutencao(@PathVariable Long idManutencao, @Valid @RequestBody ManutencaoRequest request);

    @DeleteMapping("{idManutencao}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteManutencao(@PathVariable Long idManutencao);
}

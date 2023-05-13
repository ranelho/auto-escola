package com.rlti.autoescola.frota.veiculo.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Veiculo", description = "Veiculo APIs")
@RequestMapping("/v1/veiculos")
@PreAuthorize("hasAnyRole('USER','ADMIN', 'MANAGER')")
public interface VeiculoApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    VeiculoIdResponse saveVeiculo(@Valid @RequestBody VeiculoRequest request);

    @GetMapping("/{placa}")
    @ResponseStatus(code = HttpStatus.OK)
    VeiculoResponse getOneVeiculoByPlaca(@PathVariable String placa);

    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    List<VeiculoResponse> getAllVeiculos();

    @PutMapping("/{placa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void updateVeiculo(@PathVariable String placa, @Valid @RequestBody VeiculoRequest request);

    @PatchMapping("/{placa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void inativaVeiculo(@PathVariable String placa);
}

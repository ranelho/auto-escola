package com.rlti.autoescola.frota.veiculo.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/v1/veiculo")
public interface VeiculoApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    VeiculoIdResponse post(@Valid @RequestBody VeiculoRequest request);

    @GetMapping("/{placa}")
    @ResponseStatus(code = HttpStatus.OK)
    VeiculoResponse getByPlaca(@PathVariable String placa);

    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    List<VeiculoResponse> getAll();

    @PutMapping("/{placa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void update(@PathVariable String placa, @Valid @RequestBody VeiculoRequest request);

    @DeleteMapping("/{placa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void delete(@PathVariable String placa);
}

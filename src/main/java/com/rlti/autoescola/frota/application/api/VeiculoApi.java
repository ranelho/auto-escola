package com.rlti.autoescola.frota.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/veiculo")
public interface VeiculoApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    VeiculoIdResponse saveFrota(@Valid @RequestBody VeiculoRequest request);

    @GetMapping("/{placa}")
    @ResponseStatus(code = HttpStatus.OK)
    VeiculoResponse getByPlaca(@PathVariable String placa);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<VeiculoResponse> getAll();

}

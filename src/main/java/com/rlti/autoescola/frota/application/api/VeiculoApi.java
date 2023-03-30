package com.rlti.autoescola.frota.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/veiculo")
public interface VeiculoApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    VeiculoIdResponse saveFrota(@Valid @RequestBody VeiculoRequest request);
}
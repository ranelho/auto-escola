package com.rlti.autoescola.servico.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/v1/servico")
public interface ServicoApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ServicoIdResponse saveFrota(@Valid @RequestBody ServicoRequest request);

    @GetMapping("/{idServico}")
    @ResponseStatus(code = HttpStatus.OK)
    ServicoResponse getById(@PathVariable UUID idServico);
}
package com.rlti.autoescola.orcamento.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RequestMapping("/v1/orcamento")
public interface OrcamentoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    OrcamentoResponse saveOrcamento(@Valid @RequestBody OrcamentoRequest orcamentoRequest);

    @GetMapping(value = "/{idOrcamento}")
    @ResponseStatus(code = HttpStatus.OK)
    OrcamentoResponse getOneOrcamento(@PathVariable Long idOrcamento);
}
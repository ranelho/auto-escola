package com.rlti.autoescola.orcamento.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Orcamento", description = "Orcamento APIs")
@RequestMapping("/v1/orcamentos")
@PreAuthorize("hasAnyRole('USER','ADMIN', 'MANAGER')")
public interface OrcamentoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    OrcamentoResponse saveOrcamento(@Valid @RequestBody OrcamentoRequest orcamentoRequest);

    @GetMapping(value = "/{idOrcamento}")
    @ResponseStatus(code = HttpStatus.OK)
    OrcamentoResponse getOneOrcamento(@PathVariable Long idOrcamento);
}
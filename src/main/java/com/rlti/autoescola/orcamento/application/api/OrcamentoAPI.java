package com.rlti.autoescola.orcamento.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/v1/orcamento")
public interface OrcamentoAPI {

    @PostMapping("/{idCliente},{idServico}")
    @ResponseStatus(code = HttpStatus.CREATED)
    OrcamentoResponse criaOrcamento(@PathVariable UUID idCliente, UUID idServico, @Valid @RequestBody OrcamentoRequest orcamentoRequest);
    
}

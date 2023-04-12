package com.rlti.autoescola.pagamento.appiclation.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/pagamento")
public interface PagamentoAPI {

    @GetMapping(value = "/{idMatricula}")
    @ResponseStatus(code = HttpStatus.OK)
    PagamentoResponse getPagamentoByMatricula(@PathVariable UUID idMatricula);
}

package com.rlti.autoescola.pagamento.appiclation.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/v1/pagamento")
public interface PagamentoAPI {

    @PostMapping ("/{idMatricula}")
    @ResponseStatus(code = HttpStatus.CREATED)
    PagamentoResponse post(@PathVariable UUID idMatricula, @Valid @RequestBody PagamentoRequest pagamentoRequest);

    @GetMapping(value = "/{idMatricula}")
    @ResponseStatus(code = HttpStatus.OK)
    List<PagamentoResponse> getByMatricula(@PathVariable UUID idMatricula);
}

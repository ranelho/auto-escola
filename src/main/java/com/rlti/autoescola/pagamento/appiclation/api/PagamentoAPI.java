package com.rlti.autoescola.pagamento.appiclation.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/v1/pagamento")
public interface PagamentoAPI {

    @PostMapping("/{idMatricula}")
    @ResponseStatus(code = HttpStatus.CREATED)
    PagamentoResponse post(@PathVariable UUID idMatricula, @Valid @RequestBody PagamentoRequest pagamentoRequest);

    @GetMapping(value = "/matricula/{idMatricula}")
    @ResponseStatus(code = HttpStatus.OK)
    List<PagamentoResponse> getByMatricula(@PathVariable UUID idMatricula);

    @GetMapping("/{idPagamento}")
    @ResponseStatus(code = HttpStatus.OK)
    PagamentoResponse getById(@PathVariable Long idPagamento);

    @DeleteMapping("/{idPagamento}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long idPagamento);
}
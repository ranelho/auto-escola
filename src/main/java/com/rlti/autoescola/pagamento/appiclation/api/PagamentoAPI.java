package com.rlti.autoescola.pagamento.appiclation.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Pagamento", description = "Pagamento APIs")
@RequestMapping("/v1/pagamentos")
public interface PagamentoAPI {

    @PostMapping("/{idMatricula}")
    @ResponseStatus(code = HttpStatus.CREATED)
    PagamentoResponse savePagamento(@PathVariable UUID idMatricula, @Valid @RequestBody PagamentoRequest pagamentoRequest);

    @GetMapping(value = "/matricula/{idMatricula}")
    @ResponseStatus(code = HttpStatus.OK)
    List<PagamentoResponse> getAllPagamentoByMatricula(@PathVariable UUID idMatricula);

    @GetMapping("/{idPagamento}")
    @ResponseStatus(code = HttpStatus.OK)
    PagamentoResponse getOnePagamento(@PathVariable Long idPagamento);

    @DeleteMapping("/{idPagamento}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletePagamento(@PathVariable Long idPagamento);
}
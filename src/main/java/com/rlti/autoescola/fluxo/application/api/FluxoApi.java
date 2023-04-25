package com.rlti.autoescola.fluxo.application.api;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/v1/fluxo-de-caixa")
public interface FluxoApi {

    @GetMapping("/{data}")
    @ResponseStatus(code = HttpStatus.OK)
    FluxoDeCaixaResponse getFluxoDiario(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data);

    @GetMapping(value = "/receitas-pagamento/{data}")
    @ResponseStatus(code = HttpStatus.OK)
    List<ReceitaPagamentoResponse> getReceitasPagamento(@PathVariable
                                                                @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data);
}

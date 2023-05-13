package com.rlti.autoescola.fluxo.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Fluxo de Caixa", description = "Fluxo de Caixa APIs")
@RequestMapping("/v1/fluxo-de-caixa")
@PreAuthorize("hasAnyRole('USER','ADMIN', 'MANAGER')")
public interface FluxoApi {

    @GetMapping("/{data}")
    @ResponseStatus(code = HttpStatus.OK)
    FluxoDeCaixaResponse getFluxoDiario(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data);

    @GetMapping(value = "/receitas-pagamento/{data}")
    @ResponseStatus(code = HttpStatus.OK)
    List<ReceitaPagamentoResponse> getReceitasPagamento(@PathVariable
                                                                @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data);
}

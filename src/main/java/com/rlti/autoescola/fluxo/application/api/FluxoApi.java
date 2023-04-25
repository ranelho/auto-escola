package com.rlti.autoescola.fluxo.application.api;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;

@RequestMapping("/v1/fluxo-de-caixa")
public interface FluxoApi {

    @GetMapping("/{data}")
    @ResponseStatus(code = HttpStatus.OK)
    FluxoDeCaixaResponse getFluxoDiario(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data);
}

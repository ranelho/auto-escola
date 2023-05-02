package com.rlti.autoescola.relatorios.application.api;

import com.rlti.autoescola.fluxo.application.api.FluxoDeCaixaResponse;
import com.rlti.autoescola.relatorios.application.api.respose.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Relatórios", description = "Relatórios APIs")
@RequestMapping("/v1/relatorios")
public interface RelatoriosApi {

    //TODO -> Relatório Mensal Financeiro.

    @GetMapping("/clientes")
    @ResponseStatus(code = HttpStatus.OK)
    List<RelatorioClientesResponse> getAllClientes();

    @GetMapping("/matriculas-ativas")
    @ResponseStatus(code = HttpStatus.OK)
    List<RelatorioMatriculasAtivasResponse> getAllMatriculasAtivas();

    @GetMapping("/veiculos")
    @ResponseStatus(code = HttpStatus.OK)
    List<RelatorioVeiculosResponse> getAllVeiculos();

    @GetMapping("instrutor")
    @ResponseStatus(code = HttpStatus.OK)
    List<RelatorioInstrutorResponse> getAllInstrutor();

    @GetMapping(value = "/periodo/{dataInicial},{dataFinal}")
    @ResponseStatus(code = HttpStatus.OK)
    RelatorioFluxoDeCaixaResponse getRelatorioPeriodo(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicial,
                                                      @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFinal);
}
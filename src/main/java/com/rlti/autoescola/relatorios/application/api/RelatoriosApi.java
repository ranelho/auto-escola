package com.rlti.autoescola.relatorios.application.api;

import com.rlti.autoescola.relatorios.application.api.respose.RelatorioClientesResponse;
import com.rlti.autoescola.relatorios.application.api.respose.RelatorioMatriculasAtivasResponse;
import com.rlti.autoescola.relatorios.application.api.respose.RelatorioVeiculosResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Tag(name = "Relatórios", description = "Relatórios APIs")
@RequestMapping("/v1/relatorios")
public interface RelatoriosApi {
    //TODO -> Relatório de Intrutor, aulas, uso de veiculos.
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
}

package com.rlti.autoescola.relatorios.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Tag(name = "Relatórios", description = "Relatórios APIs")
@RequestMapping("/v1/relatorios")
public interface RelatoriosApi {

    @GetMapping("/clientes")
    @ResponseStatus(code = HttpStatus.OK)
    List<RelatorioClientesResponse> getAllClientes();
}

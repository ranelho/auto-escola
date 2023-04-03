package com.rlti.autoescola.empresa.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/empresa")
public interface EmpresaApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EmpresaResponse postEmpresa(@Valid @RequestBody EmpresaRequest empresaRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<EmpresaListResponse> getEmpresas();
}

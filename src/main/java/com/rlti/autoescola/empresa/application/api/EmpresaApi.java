package com.rlti.autoescola.empresa.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/empresa")
public interface EmpresaApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EmpresaResponse postEmpresa(@Valid @RequestBody EmpresaRequest empresaRequest);
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<EmpresaListResponse> getEmpresas();
    @GetMapping(value = "/{idEmpresa}")
    @ResponseStatus(code = HttpStatus.OK)
    EmpresaDetalhadoResponse getEmpresaAtravesId(@PathVariable UUID idEmpresa);
    @DeleteMapping(value = "/{idEmpresa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaEmpresaAtravesId (@PathVariable UUID idEmpresa);
}

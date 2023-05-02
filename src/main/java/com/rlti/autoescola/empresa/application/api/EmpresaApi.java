package com.rlti.autoescola.empresa.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@Tag(name = "Empresa", description = "Empresa APIs")
@RequestMapping("/v1/empresa")
public interface EmpresaApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EmpresaResponse saveEmpresa(@Valid @RequestBody EmpresaRequest empresaRequest);

    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    List<EmpresaListResponse> getAllEmpresas();

    @GetMapping(value = "/{idEmpresa}")
    @ResponseStatus(code = HttpStatus.OK)
    EmpresaDetalhadoResponse getOneEmpresa(@PathVariable UUID idEmpresa);

    @GetMapping(value = "/cnpj")
    @ResponseStatus(code = HttpStatus.OK)
    EmpresaDetalhadoResponseCnpj getByCnpj(@RequestParam String cnpj);

    @DeleteMapping(value = "/{idEmpresa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteEmpresa(@PathVariable UUID idEmpresa);

    @PatchMapping(value = "/{idEmpresa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void updateEmpresa(@PathVariable UUID idEmpresa,
                       @Valid @RequestBody EmpresaAlteracaoRequest empresaAlteracaoRequest);
}
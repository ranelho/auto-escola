package com.rlti.autoescola.empresa.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/v1/empresa")
public interface EmpresaApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EmpresaResponse post(@Valid @RequestBody EmpresaRequest empresaRequest);

    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    List<EmpresaListResponse> getEmpresas();

    @GetMapping(value = "/{idEmpresa}")
    @ResponseStatus(code = HttpStatus.OK)
    EmpresaDetalhadoResponse getById(@PathVariable UUID idEmpresa);

    @GetMapping(value = "/cnpj")
    @ResponseStatus(code = HttpStatus.OK)
    EmpresaDetalhadoResponseCnpj getByCnpj(@RequestParam String cnpj);

    @DeleteMapping(value = "/{idEmpresa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void delete (@PathVariable UUID idEmpresa);

    @PatchMapping(value = "/{idEmpresa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void update(@PathVariable UUID idEmpresa,
                            @Valid @RequestBody EmpresaAlteracaoRequest empresaAlteracaoRequest);
}
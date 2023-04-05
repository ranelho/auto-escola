package com.rlti.autoescola.empresa.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @GetMapping(value = "/empresa/{idEmpresa}")
    @ResponseStatus(code = HttpStatus.OK)
    EmpresaDetalhadoResponse getEmpresaAtravesId(@PathVariable UUID idEmpresa);
    @GetMapping(value = "/cnpj")
    @ResponseStatus(code = HttpStatus.OK)
    EmpresaDetalhadoResponseCnpj getEmpresaAtravesCnpj(@RequestParam String cnpj);
    @DeleteMapping(value = "/{idEmpresa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaEmpresaAtravesId (@PathVariable UUID idEmpresa);
    @PatchMapping(value = "/{idEmpresa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchAlteraEmpresa(@PathVariable UUID idEmpresa,
                            @Valid @RequestBody EmpresaAlteracaoRequest empresaAlteracaoRequest);
}

package com.rlti.autoescola.matricula.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/matricula")
public interface MatriculaAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    MatriculaResponse criaMatricula(@Valid @RequestBody MatriculaRequest matriculaRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<MatriculaListResponse> getTodasMatriculas();

    @GetMapping(value = "/{idMatricula}")
    @ResponseStatus(code = HttpStatus.OK)
    MatriculaDetalhadoResponse getMatriculaAtravesId(@PathVariable UUID idMatricula);
}

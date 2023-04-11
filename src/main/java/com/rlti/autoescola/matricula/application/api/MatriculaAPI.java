package com.rlti.autoescola.matricula.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/matricula")
public interface MatriculaAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    MatriculaResponse criaMatricula(@Valid @RequestBody MatriculaRequest matriculaRequest);

}

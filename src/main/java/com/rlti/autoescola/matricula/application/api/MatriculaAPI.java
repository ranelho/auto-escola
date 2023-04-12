package com.rlti.autoescola.matricula.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @DeleteMapping(value = "/{idMatricula}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaMatriculaAtravesId(@PathVariable UUID idMatricula);

}

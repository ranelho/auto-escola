package com.rlti.autoescola.matricula.application.api;

import com.rlti.autoescola.matricula.application.api.request.MatriculaAlteracaoRequest;
import com.rlti.autoescola.matricula.application.api.request.MatriculaRequest;
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
    MatriculaIdResponse criaMatricula(@Valid @RequestBody MatriculaRequest matriculaRequest);

    @PostMapping(value = "/orcamento")
    @ResponseStatus(code = HttpStatus.CREATED)
    MatriculaIdResponse criaMatricula(@RequestParam String cpf);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<MatriculaListResponse> getTodasMatriculas();

    @GetMapping(value = "/{idMatricula}")
    @ResponseStatus(code = HttpStatus.OK)
    MatriculaDetalhadoResponse getMatriculaAtravesId(@PathVariable UUID idMatricula);

    @DeleteMapping(value = "/{idMatricula}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaMatriculaAtravesId(@PathVariable UUID idMatricula);

    @PatchMapping(value = "/{idMatricula}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchAlteraMatricula(@PathVariable UUID idMatricula,
                              @Valid @RequestBody MatriculaAlteracaoRequest matriculaAlteracaoRequest);
}

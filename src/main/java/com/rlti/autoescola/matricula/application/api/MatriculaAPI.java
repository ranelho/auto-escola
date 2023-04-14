package com.rlti.autoescola.matricula.application.api;

import com.rlti.autoescola.matricula.application.api.request.MatriculaAlteracaoRequest;
import com.rlti.autoescola.matricula.application.api.request.MatriculaRequest;
import com.rlti.autoescola.matricula.application.api.response.MatriculaDetalhadoResponse;
import com.rlti.autoescola.matricula.application.api.response.MatriculaIdResponse;
import com.rlti.autoescola.matricula.application.api.response.MatriculaListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/v1/matricula")
public interface MatriculaAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    MatriculaIdResponse criaMatricula(@Valid @RequestBody MatriculaRequest matriculaRequest);

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

    @PatchMapping("/finaliza-matricula/{idMatricula}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void finalizaMatricula(@PathVariable UUID idMatricula);

    @PatchMapping("/ativa-matricula/{idMatricula}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void ativaMatricula(@PathVariable UUID idMatricula);
}

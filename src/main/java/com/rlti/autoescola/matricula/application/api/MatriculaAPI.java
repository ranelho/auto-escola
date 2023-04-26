package com.rlti.autoescola.matricula.application.api;

import com.rlti.autoescola.matricula.application.api.request.MatriculaAlteracaoRequest;
import com.rlti.autoescola.matricula.application.api.request.MatriculaRequest;
import com.rlti.autoescola.matricula.application.api.response.MatriculaDetalhadoResponse;
import com.rlti.autoescola.matricula.application.api.response.MatriculaIdResponse;
import com.rlti.autoescola.matricula.application.api.response.MatriculaListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/v1/matricula")
public interface MatriculaAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    MatriculaIdResponse post(@Valid @RequestBody MatriculaRequest matriculaRequest);

    @PostMapping(value = "/orcamento")
    @ResponseStatus(code = HttpStatus.CREATED)
    MatriculaIdResponse post(@RequestParam String cpf);

    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    List<MatriculaListResponse> getAll();

    @GetMapping(value = "/{idMatricula}")
    @ResponseStatus(code = HttpStatus.OK)
    MatriculaDetalhadoResponse getById(@PathVariable UUID idMatricula);

    @DeleteMapping(value = "/{idMatricula}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID idMatricula);

    @PatchMapping(value = "/{idMatricula}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void update(@PathVariable UUID idMatricula,
                              @Valid @RequestBody MatriculaAlteracaoRequest matriculaAlteracaoRequest);

    @PatchMapping("/finaliza-matricula/{idMatricula}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void finalizaMatricula(@PathVariable UUID idMatricula);

    @PatchMapping("/ativa-matricula/{idMatricula}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void ativaMatricula(@PathVariable UUID idMatricula);

    @PatchMapping("/cancela-matricula/{idMatricula}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void cancelaMatricula(@PathVariable UUID idMatricula);
}

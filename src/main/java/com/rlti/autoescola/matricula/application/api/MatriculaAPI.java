package com.rlti.autoescola.matricula.application.api;

import com.rlti.autoescola.matricula.application.api.request.MatriculaAlteracaoRequest;
import com.rlti.autoescola.matricula.application.api.request.MatriculaRequest;
import com.rlti.autoescola.matricula.application.api.response.MatriculaDetalhadoResponse;
import com.rlti.autoescola.matricula.application.api.response.MatriculaIdResponse;
import com.rlti.autoescola.matricula.application.api.response.MatriculaListResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@Tag(name = "Matricula", description = "Matricula APIs")
@RequestMapping("/v1/matriculas")
@PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
public interface MatriculaAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    MatriculaIdResponse saveMatricula(@Valid @RequestBody MatriculaRequest matriculaRequest);

    @PostMapping(value = "/orcamento")
    @ResponseStatus(code = HttpStatus.CREATED)
    MatriculaIdResponse saveMatriculaByOrcamento(@RequestParam String cpf);

    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    List<MatriculaListResponse> getAllMatriculas();

    @GetMapping(value = "/{idMatricula}")
    @ResponseStatus(code = HttpStatus.OK)
    MatriculaDetalhadoResponse getOneMatricula(@PathVariable UUID idMatricula);

    @PatchMapping(value = "/{idMatricula}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void updateMatricula(@PathVariable UUID idMatricula,
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

package com.rlti.autoescola.laudo.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@Tag(name = "Laudo", description = "Laudo APIs")
@RequestMapping("/v1/laudos")
public interface LaudoApi {

    @PostMapping("{idMatricula}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    LaudoIdResponse saveLaudo(@PathVariable UUID idMatricula, @Valid @RequestBody LaudoRequest request);

    @GetMapping("{idLaudo}")
    @ResponseStatus(code = HttpStatus.OK)
    LaudoResponse getOneLaudo(@PathVariable Long idLaudo);

    @PutMapping("/update/{idLaudo}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void updateLaudo(@PathVariable Long idLaudo, @Valid @RequestBody LaudoRequest request);

    @DeleteMapping("{idLaudo}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteLaudo(@PathVariable Long idLaudo);

    @GetMapping("/all-laudos-matricula/{idMatricula}")
    @ResponseStatus(code = HttpStatus.OK)
    List<LaudoResponse> getAllLaudosByMatricula(@PathVariable UUID idMatricula);
}
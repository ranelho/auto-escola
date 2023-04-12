package com.rlti.autoescola.laudo.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/laudo")
public interface LaudoApi {

    @PostMapping("{idMatricula}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    LaudoIdResponse postLaudo(@PathVariable UUID idMatricula, @Valid @RequestBody LaudoRequest request);

    @GetMapping("{idLaudo}")
    @ResponseStatus(code = HttpStatus.OK)
    LaudoResponse getLaudoById(@PathVariable Long idLaudo);

    @PutMapping("/update/{idLaudo}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void update(@PathVariable Long idLaudo, @Valid @RequestBody LaudoRequest request);

    @DeleteMapping("{idLaudo}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleta(@PathVariable Long idLaudo);

    @GetMapping("/all-laudos-matricula/{idMatricula}")
    @ResponseStatus(code = HttpStatus.OK)
    List<LaudoResponse> getLaudoByMatricula(@PathVariable UUID idMatricula);
}
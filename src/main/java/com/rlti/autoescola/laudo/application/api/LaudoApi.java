package com.rlti.autoescola.laudo.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/v1/laudo")
public interface LaudoApi {

    @PostMapping("{idMatricula}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    LaudoIdResponse postLaudo(@PathVariable UUID idMatricula, @Valid @RequestBody LaudoRequest request);
}

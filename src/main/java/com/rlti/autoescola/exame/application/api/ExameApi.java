package com.rlti.autoescola.exame.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/v1/exame")
public interface ExameApi {
    @PostMapping("{idCliente}")
    @ResponseStatus(code = HttpStatus.CREATED)
    ExameIdResponse cadastrar(@PathVariable UUID idCliente, @Valid @RequestBody ExameRequest request);

    @GetMapping("/{idExame")
    @ResponseStatus(code = HttpStatus.OK)
    ExameResponse getExame(@PathVariable Long idExame);
}

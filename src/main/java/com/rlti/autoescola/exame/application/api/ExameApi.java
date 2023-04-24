package com.rlti.autoescola.exame.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/v1/exame")
public interface ExameApi {
    @PostMapping("{idCliente}")
    @ResponseStatus(code = HttpStatus.CREATED)
    ExameIdResponse post(@PathVariable UUID idCliente, @Valid @RequestBody ExameRequest request);

    @GetMapping("/{idExame}")
    @ResponseStatus(code = HttpStatus.OK)
    ExameResponse getById(@PathVariable Long idExame);

    @GetMapping("/all/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    List<ExameResponse> getAll(@PathVariable UUID idCliente);

    @DeleteMapping("/{idExame}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long idExame);

    @PutMapping("/{idExame}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void update(@PathVariable Long idExame, @Valid @RequestBody ExameRequest request);
}
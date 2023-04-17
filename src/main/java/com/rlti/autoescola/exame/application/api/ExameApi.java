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
    ExameIdResponse cadastrar(@PathVariable UUID idCliente, @Valid @RequestBody ExameRequest request);

    @GetMapping("/{idExame")
    @ResponseStatus(code = HttpStatus.OK)
    ExameResponse getExame(@PathVariable Long idExame);

    @GetMapping("/list/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    List<ExameResponse> listar(@PathVariable UUID idCliente);

    @DeleteMapping("/{idExame}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletar(@PathVariable Long idExame);

    @PutMapping("/{idExame}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alterar(@PathVariable Long idExame, @Valid @RequestBody ExameRequest request);
}
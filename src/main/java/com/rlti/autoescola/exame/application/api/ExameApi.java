package com.rlti.autoescola.exame.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Exame", description = "Exame APIs")
@RequestMapping("/v1/exames")
@PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
public interface ExameApi {

    @PostMapping("{idMatricula}")
    @ResponseStatus(code = HttpStatus.CREATED)
    ExameIdResponse saveExame(@PathVariable UUID idMatricula, @Valid @RequestBody ExameRequest request);

    @GetMapping("/{idExame}")
    @ResponseStatus(code = HttpStatus.OK)
    ExameResponse getOneExame(@PathVariable Long idExame);

    @GetMapping("/all/{idMatricula}")
    @ResponseStatus(code = HttpStatus.OK)
    List<ExameResponse> getAllExames(@PathVariable UUID idMatricula);

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'USER')")
    @GetMapping("/all-auth")
    @ResponseStatus(code = HttpStatus.OK)
    List<ExameResponse> getAllExames(@RequestHeader(name = "Authorization") String token);

    @DeleteMapping("/{idExame}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteExame(@PathVariable Long idExame);

    @PatchMapping("/{idExame}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void updateResultadoExame(@PathVariable Long idExame, @Valid @RequestBody ResultadoRequest request);
}
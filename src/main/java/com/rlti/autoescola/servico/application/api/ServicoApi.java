package com.rlti.autoescola.servico.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/v1/servico")
public interface ServicoApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ServicoIdResponse post(@Valid @RequestBody ServicoRequest request);

    @GetMapping("/{idServico}")
    @ResponseStatus(code = HttpStatus.OK)
    ServicoResponse getById(@PathVariable UUID idServico);

    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    List<ServicoResponse> getAll();

    @DeleteMapping("/{idServico}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID idServico);

    @PatchMapping("/update/{idServico}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void update(@PathVariable UUID idServico, @Valid @RequestBody ServicoUpdateRequest updateRequest);
}
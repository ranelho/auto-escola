package com.rlti.autoescola.servico.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Servico", description = "Servico APIs")
@RequestMapping("/v1/servicos")
public interface ServicoApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ServicoIdResponse saveServico(@Valid @RequestBody ServicoRequest request);

    @GetMapping("/{idServico}")
    @ResponseStatus(code = HttpStatus.OK)
    ServicoResponse getOneServico(@PathVariable UUID idServico);

    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    List<ServicoResponse> getAllServicos();

    @PatchMapping("/update/{idServico}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void updateServico(@PathVariable UUID idServico, @Valid @RequestBody ServicoUpdateRequest updateRequest);

    @PatchMapping("/update/status/{idServico}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void updateServicoStatus(@PathVariable UUID idServico);
}
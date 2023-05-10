package com.rlti.autoescola.instrutor.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@Tag(name = "Instrutor", description = "Instrutor APIs")
@RequestMapping("/v1/instrutores")
public interface InstrutorApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    InstrutorIdResponse saveInstrutor(@Valid @RequestBody InstrutorResquest resquest);

    @GetMapping("{idInstrutor}")
    @ResponseStatus(code = HttpStatus.OK)
    InstrutorResponse getInstrutor(@PathVariable UUID idInstrutor);

    @PatchMapping("/update/{idInstrutor}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void updateInstrutor(@PathVariable  UUID idInstrutor, @Valid @RequestBody InstrutorUpdateResquest updateRequest);

    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    List<InstrutorResponse> getAllInstrutors();

    @PatchMapping("/{idInstrutor}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void inativaInstrutor(@PathVariable UUID idInstrutor);
}

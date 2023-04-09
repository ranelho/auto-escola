package com.rlti.autoescola.instrutor.application.api;

import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/v1/instrutor")
public interface InstrutorApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    InstrutorIdResponse post(@Valid @RequestBody InstrutorResquest resquest);

    @GetMapping("{idInstrutor")
    @ResponseStatus(code = HttpStatus.OK)
    InstrutorResponse getInstrutor(@PathVariable UUID idInstrutor);

    @PatchMapping("/update/{idInstrutor}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void update(@PathVariable  UUID idInstrutor, @Valid @RequestBody InstrutorUpdateResquest updateRequest);
}

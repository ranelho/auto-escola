package com.rlti.autoescola.agenda.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/v1/agenda")
public interface AgendaAPI{

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    AgendaIdResponse post(@PathVariable UUID idInstrutor,
                        @PathVariable UUID idMatricula,
                        @PathVariable String placa,
                        @Valid @RequestBody AgendaRequest agendaRequest);

}
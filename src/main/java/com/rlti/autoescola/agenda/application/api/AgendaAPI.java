package com.rlti.autoescola.agenda.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/v1/agenda")
public interface AgendaAPI{

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    AgendaIdResponse post(@Valid @RequestBody AgendaRequest agendaRequest);

}
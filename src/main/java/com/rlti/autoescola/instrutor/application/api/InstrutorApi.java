package com.rlti.autoescola.instrutor.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@RequestMapping("/v1/instrutor")
public interface InstrutorApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    InstrutorIdResponse post(@Valid @RequestBody InstrutorResquest resquest);
}

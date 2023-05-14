package com.rlti.autoescola.contato.application.api;

import com.rlti.autoescola.cliente.application.api.ClienteContatosResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Contato", description = "Contato APIs")
@RequestMapping("v1/contatos")
public interface ContatoApi {

    @PostMapping("/{idCliente}")
    @ResponseStatus(code = HttpStatus.CREATED)
    ContatoResponse saveContato(@PathVariable UUID idCliente, @Valid @RequestBody ContatoRequest contatoRequest);

    @GetMapping(value = "/{idContato}")
    @ResponseStatus(code = HttpStatus.OK)
    ContatoResponse getOneContato(@PathVariable UUID idContato);

    @GetMapping(value = "/all-contatos-cliente/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteContatosResponse getAllContatosCliente(@PathVariable UUID idCliente);

    @DeleteMapping("/{idContato}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteContato(@PathVariable UUID idContato);

    @PatchMapping("/{idContato}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void updateContato(@PathVariable UUID idContato, @Valid @RequestBody ContatoRequest contatoRequest);
}
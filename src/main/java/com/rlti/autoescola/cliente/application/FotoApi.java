package com.rlti.autoescola.cliente.application;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RequestMapping("v1/foto")
public interface FotoApi {

    @PostMapping("{idCliente}")
    @ResponseStatus(code = HttpStatus.CREATED)
    void salvarFoto(@PathVariable UUID idCliente, @RequestParam("file") MultipartFile file) throws IOException;

    @GetMapping("{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    FotoResponse buscarFoto(@PathVariable UUID idCliente) throws IOException;
}

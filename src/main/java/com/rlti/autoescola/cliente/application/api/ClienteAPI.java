package com.rlti.autoescola.cliente.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@Tag(name = "Cliente", description = "Cliente APIs")
@RequestMapping("/v1/clientes")
public interface ClienteAPI {
    @PostMapping
    @ResponseStatus(code = CREATED)
    ClienteResponse saveCliente(@Valid @RequestBody ClienteRequest clienteRequest);

    @GetMapping("/{idCliente}")
    @ResponseStatus(code = OK)
    ClienteResponse getOneCliente(@PathVariable UUID idCliente);

    @GetMapping("/cpf")
    @ResponseStatus(code = OK)
    ClienteResponse getByCpf(@RequestParam String cpf);

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    @ResponseStatus(code = OK)
    Page<ClienteListResponse> getAllClientes(Pageable pageable);

    @PatchMapping("/{idCliente}")
    @ResponseStatus(code = NO_CONTENT)
    void updateCliente(@PathVariable UUID idCliente, @Valid @RequestBody EditaClienteRequest editaClienteRequest);

    @PutMapping("/{idCliente}/foto")
    @ResponseStatus(code = NO_CONTENT)
    void saveImagem(@PathVariable UUID idCliente, @RequestParam("foto") MultipartFile imagem) throws IOException;

}
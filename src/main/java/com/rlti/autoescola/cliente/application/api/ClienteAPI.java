package com.rlti.autoescola.cliente.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

//@PreAuthorize("hasRole('ADMIN')")
@PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
@Tag(name = "Cliente", description = "Cliente APIs")
@RequestMapping("/v1/clientes")
public interface ClienteAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ClienteResponse saveCliente(@Valid @RequestBody ClienteRequest clienteRequest);

    @GetMapping(value = "/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteResponse getOneCliente(@PathVariable UUID idCliente);

    @GetMapping(value = "/cpf")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteResponse getByCpf(@RequestParam String cpf);

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    List<ClienteListResponse> getAllClientes();

    @PatchMapping("/{idCliente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void updateCliente(@PathVariable UUID idCliente, @Valid @RequestBody EditaClienteRequest editaClienteRequest);

    @PutMapping("/{idCliente}/imagem")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void saveImagem(@PathVariable UUID idCliente, @RequestParam("imagem") MultipartFile imagem) throws IOException;
}
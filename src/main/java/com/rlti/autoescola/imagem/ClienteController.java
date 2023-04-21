package com.rlti.autoescola.imagem;

import com.rlti.autoescola.cliente.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PutMapping("/{id}/imagem")
    public ResponseEntity<Cliente> atualizarImagemCliente(@PathVariable UUID id, @RequestParam("imagem") MultipartFile imagem) {
        try {
            Cliente clienteAtualizado = clienteService.atualizarImagemCliente(id, imagem);
            return ResponseEntity.ok(clienteAtualizado);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
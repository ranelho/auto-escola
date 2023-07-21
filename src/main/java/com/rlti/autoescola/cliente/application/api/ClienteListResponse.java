package com.rlti.autoescola.cliente.application.api;

import com.rlti.autoescola.cliente.domain.Cliente;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public record ClienteListResponse(UUID idCliente, String cpf, String fullName) {
    private ClienteListResponse(Cliente cliente) {
        this(cliente.getIdCliente(), cliente.getCpf(), cliente.getFullName());
    }

    public static List<ClienteListResponse> converte(List<Cliente> clientes) {
        return clientes.stream()
                .map(ClienteListResponse::new)
                .toList();
    }

    public static Page<ClienteListResponse> convertePageable(Page<Cliente> clientes) {
        return clientes.map(ClienteListResponse::new);
    }
}
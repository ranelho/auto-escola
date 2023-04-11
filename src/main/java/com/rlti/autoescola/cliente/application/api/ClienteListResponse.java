package com.rlti.autoescola.cliente.application.api;

import com.rlti.autoescola.cliente.domain.Cliente;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ClienteListResponse {
    private final UUID idCliente;
    private final String cpf;
    private final String firstName;

    public static List<ClienteListResponse> converte(List<Cliente>clientes){
        return clientes.stream()
                .map(ClienteListResponse::new)
                .collect((Collectors.toList()));
    }
    private ClienteListResponse(Cliente cliente){
        this.idCliente = cliente.getIdCliente();
        this.cpf = cliente.getCpf();
        this.firstName = cliente.getFullName();
    }
}

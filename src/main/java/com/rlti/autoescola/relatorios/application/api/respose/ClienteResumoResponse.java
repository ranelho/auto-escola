package com.rlti.autoescola.relatorios.application.api.respose;

import com.rlti.autoescola.cliente.domain.Cliente;
import lombok.Data;

@Data
public class ClienteResumoResponse {
    String cpf;
    String fullName;

    public ClienteResumoResponse(Cliente cliente) {
        this.cpf = cliente.getCpf();
        this.fullName = cliente.getFullName();
    }
}

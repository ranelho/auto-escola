package com.rlti.autoescola.relatorios.domain;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.matricula.domain.Matricula;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Relatorios {
    LocalDate data;
    List<Cliente> clientes;
    List<Matricula> matriculas;

    public Relatorios(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}

package com.rlti.autoescola.cliente.application.repository;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.cliente.domain.Foto;

import java.util.Optional;

public interface FotoRepository {
    void salva(Foto foto);
    Optional<Foto> buscaFotoPorCliente(Cliente cliente);
}

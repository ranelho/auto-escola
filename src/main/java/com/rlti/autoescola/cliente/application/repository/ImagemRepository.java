package com.rlti.autoescola.cliente.application.repository;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.cliente.domain.Imagem;

import java.util.Optional;

public interface ImagemRepository {
    void delete(Long id);
    Imagem salva(Imagem image);
    Optional<Imagem> findByCliente(Cliente cliente);
}

package com.rlti.autoescola.cliente.application.repository;

import com.rlti.autoescola.cliente.domain.Imagem;

public interface ImagemRepository {
    void deleta(Long id);
    void salva(Imagem image);
}

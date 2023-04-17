package com.rlti.autoescola.exame.application.repository;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.exame.domain.Exame;

import java.util.List;
import java.util.UUID;

public interface ExameRepository {
    Exame salva(Exame exame);
    Exame buscaExamePorId(Long idExame);
    List<Exame> buscaExamesPorIdCliente(Cliente cliente);
}

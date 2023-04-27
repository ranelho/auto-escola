package com.rlti.autoescola.exame.application.repository;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.exame.domain.Exame;

import java.util.List;

public interface ExameRepository {
    Exame saveExame(Exame exame);
    Exame getOneExame(Long idExame);
    List<Exame> getAllExamesByCliente(Cliente cliente);
    void deleteExame(Long idExame);
}

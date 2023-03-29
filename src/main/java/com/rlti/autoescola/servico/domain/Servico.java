package com.rlti.autoescola.servico.domain;

import javax.persistence.*;
import java.util.UUID;

public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idServico;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private double valorServico;
}

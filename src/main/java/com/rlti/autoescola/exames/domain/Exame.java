package com.rlti.autoescola.exames.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.cliente.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idExame;
    @Enumerated(EnumType.STRING)
    private TipoExame tipoExame;
    private LocalDate dataExame;
    @Enumerated(EnumType.STRING)
    private Resultado resultado;
    private String observacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;
}

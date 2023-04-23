package com.rlti.autoescola.pagamento.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.matricula.domain.Matricula;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFinanceiro;
    private Situacao situacao;
    private LocalDate dataPagamento;
    private String parcela;
    private BigDecimal valorPago;

    @ManyToOne
    @JoinColumn(name = "matricula_id")
    @JsonIgnore
    private Matricula matricula;
}

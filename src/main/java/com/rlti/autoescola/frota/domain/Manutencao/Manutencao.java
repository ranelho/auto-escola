package com.rlti.autoescola.frota.domain.Manutencao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.frota.domain.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idManutencao;
    private LocalDate dataManutencao;
    private BigDecimal valorManutencao;
    private TipoManutencao tipoManutencao;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    @JsonIgnore
    private Veiculo veiculo;
}

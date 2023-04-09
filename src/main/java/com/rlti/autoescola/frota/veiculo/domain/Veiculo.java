package com.rlti.autoescola.frota.veiculo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.aula.domain.Aula;
import com.rlti.autoescola.frota.veiculo.application.api.VeiculoRequest;
import com.rlti.autoescola.frota.manutencao.domain.Manutencao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idVeiculo;
    @Column(unique = true)
    @NotBlank
    private String placa;
    private String marca;
    private String modelo;
    @NotNull
    private String ano;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "veiculo")
    @JsonIgnore
    List<Manutencao> manutencoes;

    @OneToOne(mappedBy = "veiculo")
    private Aula aula;

    public Veiculo(VeiculoRequest request) {
        this.placa = request.getPlaca().toUpperCase();
        this.marca = request.getMarca().toUpperCase();
        this.modelo = request.getModelo().toUpperCase();
        this.ano = request.getAno();
        this.tipo = request.getTipo();
    }

    public void altera(VeiculoRequest request) {
        this.placa = request.getPlaca().toUpperCase();
        this.marca = request.getMarca().toUpperCase();
        this.modelo = request.getModelo().toUpperCase();
        this.ano = request.getAno();
        this.tipo = request.getTipo();
    }
}

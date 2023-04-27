package com.rlti.autoescola.frota.veiculo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.frota.manutencao.domain.Manutencao;
import com.rlti.autoescola.frota.veiculo.application.api.VeiculoRequest;
import com.rlti.autoescola.matricula.domain.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    @Enumerated(EnumType.STRING)
    private Status status = Status.ATIVO;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "veiculo")
    @JsonIgnore
    List<Manutencao> manutencoes;

    @OneToOne(mappedBy = "veiculo")
    private Agenda agenda;

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

    public void inativa() {
        this.status = Status.INATIVO;
    }
}

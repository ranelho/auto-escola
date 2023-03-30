package com.rlti.autoescola.frota.domain;

import com.rlti.autoescola.frota.application.api.VeiculoRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    public Veiculo(VeiculoRequest request) {
        this.placa = request.getPlaca().toUpperCase();
        this.marca = request.getMarca().toUpperCase();
        this.modelo = request.getModelo().toUpperCase();
        this.ano = request.getAno();
        this.tipo = request.getTipo();
    }
}

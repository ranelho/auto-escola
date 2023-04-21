package com.rlti.autoescola.cliente.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.IOException;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Imagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private byte[] dados;

    public Imagem(byte[] bytes) {
        this.dados = bytes;
    }

    public void altera(byte[] imagem) throws IOException {
        this.dados = imagem;
    }
}

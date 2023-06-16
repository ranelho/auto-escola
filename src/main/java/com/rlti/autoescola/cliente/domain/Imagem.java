package com.rlti.autoescola.cliente.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.*;
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
    @Lob
    private byte[] foto;

    public Imagem(byte[] bytes) {
        this.foto = bytes;
    }

    @OneToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;

    public Imagem(Cliente cliente, MultipartFile imagem) throws IOException {
        this.cliente = cliente;
        this.foto = imagem.getBytes();
    }

    public void altera(byte[] imagem) throws IOException {
        this.foto = imagem;
    }
}

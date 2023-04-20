package com.rlti.autoescola.cliente.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;

@Entity
@Table(name = "fotos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private byte[] imagem;


    @OneToOne
    @JoinColumn(name = "cliente_id", unique = true)
    @JsonIgnore
    Cliente cliente;

    public Foto(Cliente cliente, MultipartFile file) throws IOException {
        this.cliente = cliente;
        this.imagem = file.getBytes();
    }
}

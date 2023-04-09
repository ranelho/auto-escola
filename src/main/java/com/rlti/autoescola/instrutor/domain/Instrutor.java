package com.rlti.autoescola.instrutor.domain;

import com.rlti.autoescola.aula.domain.Aula;
import com.rlti.autoescola.cliente.domain.groups.PessoaFisica;
import com.rlti.autoescola.servico.domain.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Instrutor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idInstrutor;
    private String nomeCompleto;
    @NotBlank(message = "Campo Obrigatório!")
    @CPF(groups = PessoaFisica.class, message = "CPF inválido!")
    @Column(unique = true)
    private String cpf;
    private String cnh;
    private LocalDate validadeCnh;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @OneToOne(mappedBy = "instrutor")
    private Aula aula;
}

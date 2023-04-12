package com.rlti.autoescola.instrutor.domain;

import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.cliente.domain.groups.PessoaFisica;
import com.rlti.autoescola.instrutor.application.api.InstrutorResquest;
import com.rlti.autoescola.instrutor.application.api.InstrutorUpdateResquest;
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
    @Column(unique = true, length = 14, updatable = false)
    private String cpf;
    @Column(unique = true, length = 11, updatable = false)
    private String cnh;
    private LocalDate validadeCnh;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @OneToOne(mappedBy = "instrutor")
    private Agenda agenda;

    public Instrutor(InstrutorResquest resquest) {
        this.nomeCompleto = resquest.getNomeCompleto().toUpperCase();
        this.cpf = resquest.getCpf();
        this.cnh = resquest.getCnh();
        this.validadeCnh = resquest.getValidadeCnh();
        this.categoria = resquest.getCategoria();
    }

    public void update(InstrutorUpdateResquest updateRequest) {
        this.nomeCompleto = updateRequest.getNomeCompleto().toUpperCase();
        this.validadeCnh = updateRequest.getValidadeCnh();
        this.categoria = updateRequest.getCategoria();
    }
}
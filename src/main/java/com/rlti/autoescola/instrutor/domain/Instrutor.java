package com.rlti.autoescola.instrutor.domain;

import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.agenda.domain.HorarioAula;
import com.rlti.autoescola.cliente.domain.groups.PessoaFisica;
import com.rlti.autoescola.instrutor.application.api.InstrutorResquest;
import com.rlti.autoescola.instrutor.application.api.InstrutorUpdateResquest;
import com.rlti.autoescola.matricula.domain.Status;
import com.rlti.autoescola.servico.domain.Categoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;
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
    @Enumerated(EnumType.STRING)
    private Status status = Status.ATIVO;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "instrutor")
    private List<Agenda> agendas;

    private List<HorarioAula> aulas;

    public Instrutor(InstrutorResquest resquest) {
        this.nomeCompleto = resquest.getNomeCompleto().toUpperCase();
        this.cpf = resquest.getCpf();
        this.cnh = resquest.getCnh();
        this.validadeCnh = resquest.getValidadeCnh();
        this.categoria = resquest.getCategoria();
    }

    public void altera(InstrutorUpdateResquest updateRequest) {
        this.nomeCompleto = updateRequest.getNomeCompleto().toUpperCase();
        this.validadeCnh = updateRequest.getValidadeCnh();
        this.categoria = updateRequest.getCategoria();
    }

    public void inativa() {
        this.status = Status.INATIVO;
    }
}
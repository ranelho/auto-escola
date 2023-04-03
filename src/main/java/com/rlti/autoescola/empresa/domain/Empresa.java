package com.rlti.autoescola.empresa.domain;

import com.rlti.autoescola.cliente.domain.TipoPessoa;
import com.rlti.autoescola.empresa.domain.groups.EmpresaGroupSequenceProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@GroupSequenceProvider(value = EmpresaGroupSequenceProvider.class)
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEmpresa;
    @CNPJ
    private String cnpj;
    @NotBlank
    private String razaoSocial;
    @NotBlank
    private String nomeFantasia;
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa = TipoPessoa.JURIDICA;
    @NotBlank
    String nomeAdministrador;
    @NotBlank
    String inscricaoMunicipal;
    @NotBlank
    String areaAtuacao;
    @NotNull
    LocalDate dataAbertura;
    @NotBlank
    @Email
    String email;
    String telefone;
    @NotNull
    String enderecoComercial;
    @NotNull
    Boolean aceitaTermos;
}

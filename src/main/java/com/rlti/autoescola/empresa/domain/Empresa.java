package com.rlti.autoescola.empresa.domain;

import com.rlti.autoescola.cliente.domain.TipoPessoa;
import com.rlti.autoescola.empresa.domain.application.api.EmpresaRequest;
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
    private String nomeAdministrador;
    @NotBlank
    private String inscricaoMunicipal;
    @NotBlank
    private String areaAtuacao;
    @NotNull
    private LocalDate dataAbertura;
    @NotBlank
    @Email
    private String email;
    private String telefone;
    @NotNull
    private String enderecoComercial;
    @NotNull
    private Boolean aceitaTermos;

    public Empresa(EmpresaRequest empresaRequest) {
    }

    public EmpresaListResponse(EmpresaRequest empresaRequest) {
        this.idEmpresa = empresaRequest.getIdEmpresa();
        this.razaoSocial = empresaRequest.getRazaoSocial();
        this.nomeFantasia = nomeFantasia;
        this.tipoPessoa = tipoPessoa;
        this.nomeAdministrador = nomeAdministrador;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.areaAtuacao = areaAtuacao;
        this.dataAbertura = dataAbertura;
        this.email = email;
        this.telefone = telefone;
        this.enderecoComercial = enderecoComercial;
        this.aceitaTermos = aceitaTermos;
    }
}

package com.rlti.autoescola.empresa.domain;

import com.rlti.autoescola.cliente.domain.enums.TipoPessoa;
import com.rlti.autoescola.empresa.application.api.EmpresaUpdateRequest;
import com.rlti.autoescola.empresa.application.api.EmpresaRequest;
import com.rlti.autoescola.empresa.domain.groups.EmpresaGroupSequenceProvider;
import com.rlti.autoescola.empresa.domain.groups.PessoaJuridica;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.group.GroupSequenceProvider;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
     UUID idEmpresa;
    @NotBlank
     String razaoSocial;
    @NotBlank
    private String nomeFantasia;
    @NotBlank
    @Column(unique = true)
    @CNPJ(groups = PessoaJuridica.class, message = "CNPJ inválido!")
    private String cnpj;
    @Transient
    final TipoPessoa tipoPessoa = TipoPessoa.JURIDICA;
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
    @Column(unique = true)
    private String email;
    private String telefone;
    @NotNull
    private String enderecoComercial;
    @NotNull
    private Boolean aceitaTermos;

   public Empresa(EmpresaRequest empresaRequest) {
        this.razaoSocial = empresaRequest.getRazaoSocial().toUpperCase();
        this.nomeFantasia = empresaRequest.getNomeFantasia().toUpperCase();
        this.cnpj = empresaRequest.getCnpj();
        this.nomeAdministrador = empresaRequest.getNomeAdministrador().toUpperCase();
        this.inscricaoMunicipal = empresaRequest.getInscricaoMunicipal();
        this.areaAtuacao = empresaRequest.getAreaAtuacao().toUpperCase();
        this.dataAbertura = empresaRequest.getDataAbertura();
        this.email = empresaRequest.getEmail().toLowerCase();
        this.telefone = empresaRequest.getTelefone();
        this.enderecoComercial = empresaRequest.getEnderecoComercial();
        this.aceitaTermos = empresaRequest.getAceitaTermos();
    }

    public void altera(EmpresaUpdateRequest empresaUpdateRequest) {
        this.nomeFantasia = empresaUpdateRequest.getNomeFantasia().toUpperCase();
        this.nomeAdministrador = empresaUpdateRequest.getNomeAdministrador().toUpperCase();
        this.areaAtuacao = empresaUpdateRequest.getAreaAtuacao().toUpperCase();
        this.dataAbertura = empresaUpdateRequest.getDataAbertura();
        this.email = empresaUpdateRequest.getEmail().toLowerCase();
        this.telefone = empresaUpdateRequest.getTelefone();
        this.enderecoComercial = empresaUpdateRequest.getEnderecoComercial();
    }
}
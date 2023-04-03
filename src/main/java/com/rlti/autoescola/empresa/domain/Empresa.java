package com.rlti.autoescola.empresa.domain;

import com.rlti.autoescola.empresa.application.api.EmpresaRequest;
import com.rlti.autoescola.empresa.domain.groups.EmpresaGroupSequenceProvider;
import com.rlti.autoescola.empresa.domain.groups.PessoaJuridica;
import lombok.AccessLevel;
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
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
@GroupSequenceProvider(value = EmpresaGroupSequenceProvider.class)
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEmpresa;
    @NotBlank
    private String razaoSocial;
    @NotBlank
    private String nomeFantasia;
    @NotBlank
    @Column(unique = true)
    @CNPJ(groups = PessoaJuridica.class)
    private String cnpj;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Tipo pessoa é obrigatório")
    TipoPessoa tipoPessoa = TipoPessoa.JURIDICA;
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
        this.razaoSocial = empresaRequest.getRazaoSocial();
        this.nomeFantasia = empresaRequest.getNomeFantasia();
        this.cnpj = empresaRequest.getCnpj();
        this.nomeAdministrador = empresaRequest.getNomeAdministrador();
        this.inscricaoMunicipal = empresaRequest.getInscricaoMunicipal();
        this.areaAtuacao = empresaRequest.getAreaAtuacao();
        this.dataAbertura = empresaRequest.getDataAbertura();
        this.email = empresaRequest.getEmail();
        this.telefone = empresaRequest.getTelefone();
        this.enderecoComercial = empresaRequest.getEnderecoComercial();
        this.aceitaTermos = empresaRequest.getAceitaTermos();
    }
}

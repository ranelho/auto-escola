package com.rlti.autoescola.empresa.application.api;

import com.rlti.autoescola.empresa.domain.Empresa;
import com.rlti.autoescola.empresa.domain.TipoPessoa;
import lombok.Value;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.UUID;
@Value
public class EmpresaDetalhadoResponse {
    UUID idEmpresa;
    String razaoSocial;
    String nomeFantasia;
    @NotBlank
    @CNPJ
    String cnpj;
    TipoPessoa tipoPessoa;
    String nomeAdministrador;
    String inscricaoMunicipal;
    String areaAtuacao;
    LocalDate dataAbertura;
    String email;
    String telefone;
    String enderecoComercial;

    public EmpresaDetalhadoResponse(Empresa empresa) {
        this.idEmpresa = empresa.getIdEmpresa();
        this.razaoSocial = empresa.getRazaoSocial();
        this.nomeFantasia = empresa.getNomeFantasia();
        this.cnpj = empresa.getCnpj();
        this.tipoPessoa = empresa.getTipoPessoa();
        this.nomeAdministrador = empresa.getNomeAdministrador();
        this.inscricaoMunicipal = empresa.getInscricaoMunicipal();
        this.areaAtuacao = empresa.getAreaAtuacao();
        this.dataAbertura = empresa.getDataAbertura();
        this.email = empresa.getEmail();
        this.telefone = empresa.getTelefone();
        this.enderecoComercial = empresa.getEnderecoComercial();
    }
}

package com.rlti.autoescola.empresa.domain.application.api;

import com.rlti.autoescola.cliente.domain.TipoPessoa;
import com.rlti.autoescola.empresa.domain.Empresa;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;
@Value
public class EmpresaListResponse {
    UUID idEmpresa;
    String razaoSocial;
    String nomeFantasia;
    TipoPessoa tipoPessoa;
    String nomeAdministrador;
    String inscricaoMunicipal;
    String areaAtuacao;
    LocalDate dataAbertura;
    String email;
    String telefone;
    String enderecoComercial;

    public EmpresaListResponse(Empresa empresa) {
        this.idEmpresa = empresa.getIdEmpresa();
        this.razaoSocial = empresa.getRazaoSocial();
        this.nomeFantasia = empresa.getNomeFantasia();
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

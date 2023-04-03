package com.rlti.autoescola.empresa.application.api;

import com.rlti.autoescola.empresa.domain.TipoPessoa;
import com.rlti.autoescola.empresa.domain.Empresa;
import lombok.Value;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class EmpresaListResponse {
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

    public static List<EmpresaListResponse> converte(List<Empresa> empresas) {
        return empresas.stream()
                .map(empresa -> new EmpresaListResponse(empresa))
                .collect(Collectors.toList());
    }

    public EmpresaListResponse(Empresa empresa) {
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

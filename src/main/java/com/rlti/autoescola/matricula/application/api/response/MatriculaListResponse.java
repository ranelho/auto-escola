package com.rlti.autoescola.matricula.application.api.response;

import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class MatriculaListResponse {
    UUID idMatricula;
    String cpf;
    TipoPagamento tipoPagamento;
    BigDecimal valorEntrada;
    int desconto;
    int quantidadeParcelas;
    BigDecimal valorFinal;
    LocalDate dataMatricula;
    String fullName;
    String observacao;
    String servico;
    String status;

    public static List<MatriculaListResponse> converte(List<Matricula>matriculas){
        return matriculas.stream()
                .map(MatriculaListResponse::new)
                .collect(Collectors.toList());
    }

    public MatriculaListResponse(Matricula matricula) {
        this.idMatricula = matricula.getIdMatricula();
        this.cpf = matricula.getCliente().getCpf();
        this.tipoPagamento = matricula.getTipoPagamento();
        this.valorEntrada = matricula.getValorEntrada();
        this.desconto = matricula.getDesconto();
        this.quantidadeParcelas = matricula.getQuantidadeParcelas();
        this.valorFinal = matricula.getValorFinal();
        this.dataMatricula = matricula.getDataMatricula();
        this.fullName = matricula.getCliente().getFullName();
        this.observacao = matricula.getObservacao();
        this.servico = matricula.getServico().getCategoria().toString();
        this.status = matricula.getStatus().toString();
    }
}
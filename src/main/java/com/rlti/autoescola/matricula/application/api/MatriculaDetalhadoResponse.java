package com.rlti.autoescola.matricula.application.api;

import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Value
public class MatriculaDetalhadoResponse {
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

    public MatriculaDetalhadoResponse(Matricula matricula) {
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
    }
}

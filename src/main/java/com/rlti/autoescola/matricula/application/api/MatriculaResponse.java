package com.rlti.autoescola.matricula.application.api;

import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class MatriculaResponse {
    TipoPagamento tipoPagamento;
    Double valorEntrada;
    int desconto;
    int quantidadeParcelas;
    BigDecimal valorFinal;
    LocalDate dataMatricula;
    String cpf;
    String fistName;
    Long idOrcamento;
    UUID idMatricula;
    String observacao;


    public MatriculaResponse(Matricula matricula) {
        this.tipoPagamento = matricula.getTipoPagamento();
        this.valorEntrada = matricula.getValorEntrada();
        this.desconto = matricula.getDesconto();
        this.quantidadeParcelas = matricula.getQuantidadeParcelas();
        this.valorFinal = matricula.getValorFinal();
        this.dataMatricula = matricula.getDataMatricula();
        this.cpf = matricula.getCliente().getCpf();
        this.fistName = matricula.getCliente().getFirstName();
        this.idOrcamento = matricula.getIdOrcamento();
        this.idMatricula = matricula.getIdMatricula();
        this.observacao = matricula.getObservacao();
    }
}

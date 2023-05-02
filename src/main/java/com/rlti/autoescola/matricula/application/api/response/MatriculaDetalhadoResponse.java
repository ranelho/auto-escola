package com.rlti.autoescola.matricula.application.api.response;

import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import lombok.Value;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.UUID;

@Value
public class MatriculaDetalhadoResponse {
    UUID idMatricula;
    String cpf;
    TipoPagamento tipoPagamento;
    BigDecimal valorEntrada;
    int quantidadeParcelas;
    BigDecimal valorServico;
    BigDecimal desconto;
    BigDecimal valorFinal;
    LocalDate dataMatricula;
    String fullName;
    String observacao;
    String status;

    public MatriculaDetalhadoResponse(Matricula matricula) {
        this.idMatricula = matricula.getIdMatricula();
        this.cpf = matricula.getCliente().getCpf();
        this.tipoPagamento = matricula.getTipoPagamento();
        this.valorEntrada = matricula.getValorEntrada();
        this.quantidadeParcelas = matricula.getQuantidadeParcelas();
        this.valorServico = matricula.getServico().getValorServico();
        this.desconto =  calculaDesconto(matricula.getDesconto(), matricula.getServico().getValorServico()) ;
        this.valorFinal = matricula.getValorFinal();
        this.dataMatricula = matricula.getDataMatricula();
        this.fullName = matricula.getCliente().getFullName();
        this.observacao = matricula.getObservacao();
        this.status = matricula.getStatus().toString();
    }

    public static BigDecimal calculaDesconto(int desconto, BigDecimal valorServico) {
        return valorServico.multiply(new BigDecimal(desconto)).divide(BigDecimal.valueOf(100),
                2, RoundingMode.HALF_UP);
    }
}

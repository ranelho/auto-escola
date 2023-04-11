package com.rlti.autoescola.matricula.application.api;

import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.matricula.domain.TipoServico;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class MatriculaListResponse {
    TipoPagamento tipoPagamento;
    Double valorEntrada;
    int desconto;
    int quantidadeParcelas;
    BigDecimal valorFinal;
    LocalDate dataMatricula;
    String cpf;
    String fullName;
    Long idOrcamento;
    UUID idMatricula;
    String observacao;

    public static List<MatriculaListResponse> converte(List<Matricula> matriculas){
        return matriculas.stream()
                .map(MatriculaListResponse::new)
                .collect(Collectors.toList());
    }

    public MatriculaListResponse(Matricula matricula) {
        this.tipoPagamento = matricula.getTipoPagamento();
        this.valorEntrada = matricula.getValorEntrada();
        this.desconto = matricula.getDesconto();
        this.quantidadeParcelas = matricula.getQuantidadeParcelas();
        this.valorFinal = matricula.getValorFinal();
        this.dataMatricula = matricula.getDataMatricula();
        this.cpf = matricula.getCliente().getCpf();
        this.fullName = matricula.getCliente().getFullName();
        this.idOrcamento = matricula.getIdOrcamento();
        this.idMatricula = matricula.getIdMatricula();
        this.observacao = matricula.getObservacao();
    }
}

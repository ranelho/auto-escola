package com.rlti.autoescola.relatorios.application.api.respose;

import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.rlti.autoescola.matricula.application.api.response.MatriculaDetalhadoResponse.calculaDesconto;

@Data
public class RelatorioMatriculasAtivasResponse {
    UUID idMatricula;
    String servico;
    String cpf;
    String fullName;
    TipoPagamento tipoPagamento;
    BigDecimal valorServico;
    BigDecimal desconto;
    BigDecimal valorEntrada;
    BigDecimal valorFinal;
    LocalDate dataMatricula;

    public RelatorioMatriculasAtivasResponse(Matricula matricula) {
        this.idMatricula = matricula.getIdMatricula();
        this.servico = matricula.getServico().getCategoria().toString();
        this.cpf = matricula.getCliente().getCpf();
        this.fullName = matricula.getCliente().getFullName();
        this.tipoPagamento = matricula.getTipoPagamento();
        this.valorServico = matricula.getServico().getValorServico();
        this.desconto = calculaDesconto(matricula.getDesconto(), matricula.getServico().getValorServico()) ;
        this.valorEntrada = matricula.getValorEntrada();
        this.valorFinal = matricula.getValorFinal();
        this.dataMatricula = matricula.getDataMatricula();
    }

    public static List<RelatorioMatriculasAtivasResponse> convert(List<Matricula> matriculas) {
        return matriculas.stream()
                .map(RelatorioMatriculasAtivasResponse::new)
                .collect(Collectors.toList());
    }
}

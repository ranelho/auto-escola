package com.rlti.autoescola.relatorios.application.api;

import com.rlti.autoescola.exame.domain.Exame;
import com.rlti.autoescola.laudo.domain.Laudo;
import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.pagamento.domain.Pagamento;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class RelatorioMatriculaResponse {
    UUID idMatricula;
    TipoPagamento tipoPagamento;
    BigDecimal valorEntrada;
    BigDecimal valorFinal;
    LocalDate dataMatricula;
    String observacao;
    String status;
    List<Exame> exames;
    List<Laudo> laudos;
    List<Pagamento> pagamentos;

    public RelatorioMatriculaResponse(Matricula matricula) {
        this.idMatricula = matricula.getIdMatricula();
        this.tipoPagamento = matricula.getTipoPagamento();
        this.valorEntrada = matricula.getValorEntrada();
        this.valorFinal = matricula.getValorFinal();
        this.dataMatricula = matricula.getDataMatricula();
        this.observacao = matricula.getObservacao();
        this.status = matricula.getStatus().toString();
        this.exames = matricula.getExames().stream().toList();
        this.laudos = matricula.getLaudo().stream().toList();
        this.pagamentos = matricula.getPagamentos().stream().toList();
    }

    public static List<RelatorioMatriculaResponse> converte(List<Matricula> matriculas){
        return matriculas.stream()
                .map(RelatorioMatriculaResponse::new)
                .collect(Collectors.toList());
    }
}

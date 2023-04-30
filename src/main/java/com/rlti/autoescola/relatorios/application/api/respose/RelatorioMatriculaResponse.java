package com.rlti.autoescola.relatorios.application.api.respose;

import com.rlti.autoescola.exame.application.api.ExameResumoResponse;
import com.rlti.autoescola.laudo.application.api.LaudoResumoResponse;
import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.pagamento.appiclation.api.PagamentoResumoResponse;
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
    String status;
    List<ExameResumoResponse> exames;
    List<LaudoResumoResponse> laudos;
    List<PagamentoResumoResponse> pagamentos;

    public RelatorioMatriculaResponse(Matricula matricula) {
        this.idMatricula = matricula.getIdMatricula();
        this.tipoPagamento = matricula.getTipoPagamento();
        this.valorEntrada = matricula.getValorEntrada();
        this.valorFinal = matricula.getValorFinal();
        this.dataMatricula = matricula.getDataMatricula();
        this.status = matricula.getStatus().toString();
        this.exames = ExameResumoResponse.converte(matricula.getExames());
        this.laudos = LaudoResumoResponse.converte(matricula.getLaudo());
        this.pagamentos = PagamentoResumoResponse.convert(matricula.getPagamentos());
    }

    public static List<RelatorioMatriculaResponse> converte(List<Matricula> matriculas){
        return matriculas.stream()
                .map(RelatorioMatriculaResponse::new)
                .collect(Collectors.toList());
    }
}
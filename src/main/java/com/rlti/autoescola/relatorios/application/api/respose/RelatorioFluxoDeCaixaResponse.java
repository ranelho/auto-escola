package com.rlti.autoescola.relatorios.application.api.respose;

import com.rlti.autoescola.fluxo.application.api.ManutencaoFluxoResponse;
import com.rlti.autoescola.fluxo.application.api.PagamentoFluxoResponse;
import com.rlti.autoescola.fluxo.application.api.ReceitaPagamentoResponse;
import com.rlti.autoescola.fluxo.domain.Fluxo;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class RelatorioFluxoDeCaixaResponse {
    String periodo;
    List<PagamentoFluxoResponse> receitas;
    List<ManutencaoFluxoResponse> despesas;
    List<ReceitaPagamentoResponse> receitaPorTipoPagamento;
    BigDecimal totalReceitas;
    BigDecimal totalDespesas;
    BigDecimal saldo;

    public RelatorioFluxoDeCaixaResponse(Fluxo fluxo, LocalDate dataInicial, LocalDate dataFinal) {
        this.periodo = dataInicial.toString() + " até " + dataFinal.toString();
        this.receitas = fluxo.getPagamentos();
        this.despesas = fluxo.getManutencoes();
        this.saldo = fluxo.getSaldoGeral();
        this.totalReceitas = fluxo.getValorTotalReceitas();
        this.totalDespesas = fluxo.getValorTotalDespesas();
        this.receitaPorTipoPagamento = fluxo.getReceitaPagamentoResponseList();
    }

    public static List<RelatorioFluxoDeCaixaResponse> converte(List<Fluxo> fluxo, LocalDate dataInicial, LocalDate dataFinal) {
        return fluxo.stream().map(f -> new RelatorioFluxoDeCaixaResponse(f, dataInicial, dataFinal)).collect(Collectors.toList());
    }
}
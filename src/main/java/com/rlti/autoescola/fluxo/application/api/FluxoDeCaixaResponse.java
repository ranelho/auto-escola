package com.rlti.autoescola.fluxo.application.api;

import com.rlti.autoescola.fluxo.domain.Fluxo;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class FluxoDeCaixaResponse {
    List<PagamentoFluxoResponse> receitas;
    List<ManutencaoFluxoResponse> despesas;
    List<ReceitaPagamentoResponse> receitaPagamentoResponseList;
    BigDecimal totalReceitas;
    BigDecimal totalDespesas;
    BigDecimal saldo;

    public FluxoDeCaixaResponse(Fluxo fluxo){
        this.receitas = fluxo.getPagamentos();
        this.despesas = fluxo.getManutencoes();
        this.saldo = fluxo.getSaldoGeral();
        this.totalReceitas = fluxo.getValorTotalReceitas();
        this.totalDespesas = fluxo.getValorTotalDespesas();
        this.receitaPagamentoResponseList = fluxo.getReceitaPagamentoResponseList();
    }

    public static List<FluxoDeCaixaResponse> converte(List<Fluxo> fluxo) {
        return fluxo.stream()
                .map(FluxoDeCaixaResponse::new)
                .collect(Collectors.toList());
    }
}
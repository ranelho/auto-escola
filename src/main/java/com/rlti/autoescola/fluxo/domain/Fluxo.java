package com.rlti.autoescola.fluxo.domain;

import com.rlti.autoescola.fluxo.application.api.ManutencaoFluxoResponse;
import com.rlti.autoescola.fluxo.application.api.PagamentoFluxoResponse;
import com.rlti.autoescola.fluxo.application.api.ReceitaPagamentoResponse;
import com.rlti.autoescola.frota.manutencao.domain.Manutencao;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.pagamento.domain.Pagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Fluxo {
    private BigDecimal valorTotalReceitas;
    private BigDecimal valorTotalDespesas;
    private BigDecimal saldoGeral;
    private TipoPagamento tipoPagamento;
    List<PagamentoFluxoResponse> pagamentos;
    List<ManutencaoFluxoResponse> manutencoes;
    List<ReceitaPagamentoResponse> receitaPagamentoResponseList;

    public Fluxo(List<Pagamento> pagamentos, List<Manutencao> manutencoes) {
        this.pagamentos = PagamentoFluxoResponse.convert(pagamentos);
        this.manutencoes = ManutencaoFluxoResponse.convert(manutencoes);
        this.valorTotalReceitas = somaReceita(pagamentos);
        this.valorTotalDespesas = somaDespesa(manutencoes);
        this.saldoGeral = valorTotalReceitas.subtract(valorTotalDespesas);
    }

    public Fluxo(TipoPagamento tipoPagamento, List<Pagamento> pagamentos) {
        this.tipoPagamento = tipoPagamento;
        this.valorTotalReceitas = somaReceita(pagamentos);
    }

    public Fluxo(List<Pagamento> pagamentos, List<Manutencao> manutencoes, List<ReceitaPagamentoResponse> receitas) {
        this.pagamentos = PagamentoFluxoResponse.convert(pagamentos);
        this.manutencoes = ManutencaoFluxoResponse.convert(manutencoes);
        this.valorTotalReceitas = somaReceita(pagamentos);
        this.valorTotalDespesas = somaDespesa(manutencoes);
        this.saldoGeral = valorTotalReceitas.subtract(valorTotalDespesas);
        this.receitaPagamentoResponseList = receitas;
    }

    private BigDecimal somaDespesa(List<Manutencao> manutencoes) {
        return manutencoes
                .stream()
                .map(Manutencao::getValorManutencao)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal somaReceita(List<Pagamento> pagamentos) {
        return pagamentos
                .stream()
                .map(Pagamento::getValorPago)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
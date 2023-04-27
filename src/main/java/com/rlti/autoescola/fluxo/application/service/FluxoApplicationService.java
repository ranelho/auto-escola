package com.rlti.autoescola.fluxo.application.service;

import com.rlti.autoescola.fluxo.application.api.FluxoDeCaixaResponse;
import com.rlti.autoescola.fluxo.application.api.ReceitaPagamentoResponse;
import com.rlti.autoescola.fluxo.domain.Fluxo;
import com.rlti.autoescola.frota.manutencao.application.repository.ManutencaoRepository;
import com.rlti.autoescola.frota.manutencao.domain.Manutencao;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.pagamento.appiclation.repository.PagamentoRepository;
import com.rlti.autoescola.pagamento.domain.Pagamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class FluxoApplicationService implements FluxoService {
    private final PagamentoRepository pagamentoRepository;
    private final ManutencaoRepository manutencaoRepository;

    @Override
    public FluxoDeCaixaResponse getFluxoDiario(LocalDate data) {
        log.info("[inicia] FluxoApplicationService - getFluxoDiario");
        List<Pagamento> pagamentoList = pagamentoRepository.getAllPagamentoByData(data);
        List<Manutencao> manutencaoList = manutencaoRepository.getAllManutencoesByData(data);
        List<ReceitaPagamentoResponse> receitaPagamentoResponseList = getReceitasPagamento(data);
        Fluxo fluxo = new Fluxo(pagamentoList, manutencaoList,  receitaPagamentoResponseList);
        log.info("[finaliza] FluxoApplicationService - getFluxoDiario");
        return new FluxoDeCaixaResponse(fluxo);
    }

    @Override
    public List<ReceitaPagamentoResponse> getReceitasPagamento(LocalDate data) {
        log.info("[inicia] FluxoApplicationService - getReceitasPagamento");
        List<Fluxo> fluxos = new ArrayList<>();
        for (TipoPagamento tipoPagamento : TipoPagamento.values()) {
            List<Pagamento> pagamentos = pagamentoRepository.getAllPagamentoByTipoPagamento(tipoPagamento, data);
            if(pagamentos != null && !pagamentos.isEmpty()) {
                fluxos.add(new Fluxo(tipoPagamento, pagamentos));
            }
        }
        log.info("[finaliza] FluxoApplicationService - getReceitasPagamento");
        return ReceitaPagamentoResponse.converte(fluxos);
    }
}

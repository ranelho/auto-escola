package com.rlti.autoescola.fluxo.application.service;

import com.rlti.autoescola.fluxo.application.api.FluxoDeCaixaResponse;
import com.rlti.autoescola.fluxo.domain.Fluxo;
import com.rlti.autoescola.frota.manutencao.application.repository.ManutencaoRepository;
import com.rlti.autoescola.frota.manutencao.application.service.ManutencaoService;
import com.rlti.autoescola.frota.manutencao.domain.Manutencao;
import com.rlti.autoescola.pagamento.appiclation.repository.PagamentoRepository;
import com.rlti.autoescola.pagamento.appiclation.service.PagamentoService;
import com.rlti.autoescola.pagamento.domain.Pagamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        List<Pagamento> pagamentoList = pagamentoRepository.getAllData(data);
        List<Manutencao> manutencaoList = manutencaoRepository.getAllData(data);
        Fluxo fluxo = new Fluxo(pagamentoList, manutencaoList);
        log.info("[finaliza] FluxoApplicationService - getFluxoDiario");
        return new FluxoDeCaixaResponse(fluxo);
    }
}

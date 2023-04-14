package com.rlti.autoescola.pagamento.appiclation.service;

import com.rlti.autoescola.matricula.application.repository.MatriculaRepository;
import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.pagamento.appiclation.api.PagamentoResponse;
import com.rlti.autoescola.pagamento.appiclation.repository.PagamentoRepository;
import com.rlti.autoescola.pagamento.domain.Pagamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PagamentoApplicationService implements PagamentoService {
    private final PagamentoRepository pagamentoRepository;
    private final MatriculaRepository matriculaRepository;

    @Override
    public List<PagamentoResponse> getPagamentoByMatricula(UUID idMatricula) {
        log.info("[inicia] PagamentoApplicationService - getPagamentoByMatricula");
        Matricula matricula = matriculaRepository.matriculaAtravesId(idMatricula);
        List<Pagamento> pagamento = pagamentoRepository.getPagamento(matricula);
        log.info("[finaliza] PagamentoApplicationService - getPagamentoByMatricula");
        return PagamentoResponse.convert(pagamento);
    }
}

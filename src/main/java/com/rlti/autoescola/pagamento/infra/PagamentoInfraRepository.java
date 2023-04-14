package com.rlti.autoescola.pagamento.infra;

import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.pagamento.appiclation.repository.PagamentoRepository;
import com.rlti.autoescola.pagamento.domain.Pagamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PagamentoInfraRepository implements PagamentoRepository {
    private final PagamentoSpringDataJPARepository pagamentoSpringDataJPARepository;

    @Override
    public List<Pagamento> getPagamento(Matricula matricula) {
        log.info("[inicia] PagamentoInfraRepository - getPagamento");
        List<Pagamento> pagamentos = pagamentoSpringDataJPARepository.findByMatricula(matricula);
        log.info("[finaliza] PagamentoInfraRepository - getPagamento");
        return pagamentos;
    }

    @Override
    public BigDecimal totalPago(Matricula matricula) {
        log.info("[inicia] PagamentoInfraRepository - somaPagamento");
        BigDecimal totalPago = pagamentoSpringDataJPARepository.findSumValorPagoByMatricula(matricula);
        log.info("[finaliza] PagamentoInfraRepository - somaPagamento");
        return totalPago;
    }
}
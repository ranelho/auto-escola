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
        log.info("[inicia] PagamentoInfraRepository - totalPago");
        List<Pagamento> pagamentos = pagamentoSpringDataJPARepository.findByMatricula(matricula);
      /*  BigDecimal totalPago = BigDecimal.ZERO;
        if (pagamentos != null && !pagamentos.isEmpty()) {
            for (Pagamento pagamento : pagamentos) {
                totalPago = totalPago.add(pagamento.getValorPago());
            }
        }*/
        BigDecimal totalPago = pagamentos.stream()
                .map(Pagamento::getValorPago)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        log.info("[finaliza] PagamentoInfraRepository - totalPago");
        return totalPago;
    }
    @Override
    public Pagamento salva(Pagamento pagamento) {
        log.info("[inicia] PagamentoInfraRepository - salva");
        Pagamento pago = pagamentoSpringDataJPARepository.save(pagamento);
        log.info("[inicia] PagamentoInfraRepository - salva");
        return pago;
    }
}
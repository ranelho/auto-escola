package com.rlti.autoescola.pagamento.infra;

import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.pagamento.appiclation.repository.PagamentoRepository;
import com.rlti.autoescola.pagamento.domain.Pagamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    @Override
    public Pagamento getById(Long idPagamento) {
        log.info("[inicia] PagamentoInfraRepository - getById");
        Optional<Pagamento> optionalPagamento = pagamentoSpringDataJPARepository.findById(idPagamento);
        Pagamento pagamento = optionalPagamento
                .orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND,"Pagamento inexistente!"));
        log.info("[finaliza] PagamentoInfraRepository - getById");
        return pagamento;
    }
    @Override
    public void delete(Long idPagamento) {
        log.info("[inicia] PagamentoInfraRepository - delete");
        pagamentoSpringDataJPARepository.deleteById(idPagamento);
        log.info("[inicia] PagamentoInfraRepository - delete");
    }

    @Override
    public List<Pagamento> getAllData(LocalDate data) {
        log.info("[inicia] PagamentoInfraRepository - getAllData");
        List<Pagamento> pagamentos = pagamentoSpringDataJPARepository.findByDataPagamento(data);
        log.info("[finaliza] PagamentoInfraRepository - getAllData");
        return pagamentos;
    }

    @Override
    public List<Pagamento> getCategoriaAllData(TipoPagamento tipoPagamento, LocalDate data) {
        log.info("[inicia] PagamentoInfraRepository - getCategoriaAllData");
        List<Pagamento> pagamentos = pagamentoSpringDataJPARepository.findByTipoPagamentoAndDataPagamento(tipoPagamento,data);;
        log.info("[finaliza] PagamentoInfraRepository - getCategoriaAllData");
        return pagamentos;
    }
}
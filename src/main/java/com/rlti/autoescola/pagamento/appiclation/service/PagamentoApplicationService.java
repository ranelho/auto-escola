package com.rlti.autoescola.pagamento.appiclation.service;

import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.matricula.application.repository.MatriculaRepository;
import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.pagamento.appiclation.api.PagamentoRequest;
import com.rlti.autoescola.pagamento.appiclation.api.PagamentoResponse;
import com.rlti.autoescola.pagamento.appiclation.repository.PagamentoRepository;
import com.rlti.autoescola.pagamento.domain.Pagamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PagamentoApplicationService implements PagamentoService {
    private final PagamentoRepository pagamentoRepository;
    private final MatriculaRepository matriculaRepository;

    @Override
    public PagamentoResponse savePagamento(UUID idMatricula, PagamentoRequest pagamentoRequest) {
        log.info("[inicia] PagamentoApplicationService - savePagamento");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        BigDecimal totalPago = pagamentoRepository.totalPago(matricula);
        BigDecimal saldoAPagar = matricula.getValorFinal().subtract(totalPago);
        if (pagamentoRequest.getValorPago().compareTo(saldoAPagar)<=0){
            Pagamento pagamento = pagamentoRepository.salvaPagamento(new Pagamento(pagamentoRequest, matricula));
            log.info("[finaliza] PagamentoApplicationService - savePagamento");
            return new PagamentoResponse(pagamento);
        } else {
            throw APIException.build(HttpStatus.BAD_REQUEST,
                    "Pagamento maior que o serviço contratado. Valor a Pagar R$: " + saldoAPagar);
        }
    }
    @Override
    public List<PagamentoResponse> getAllPagamentoByMatricula(UUID idMatricula) {
        log.info("[inicia] PagamentoApplicationService - getAllPagamentoByMatricula");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        List<Pagamento> pagamento = pagamentoRepository.getAllPagamentoByMatricula(matricula);
        log.info("[finaliza] PagamentoApplicationService - getAllPagamentoByMatricula");
        return PagamentoResponse.convert(pagamento);
    }
    @Override
    public PagamentoResponse getOnePagamento(Long idPagamento) {
        log.info("[inicia] PagamentoApplicationService - getOnePagamento");
        Pagamento pagamento = pagamentoRepository.getOnePagamento(idPagamento);
        log.info("[finaliza] PagamentoApplicationService - getOnePagamento");
        return new PagamentoResponse(pagamento);
    }
    @Override
    public void savePagamentoByEntrada(Matricula matricula, TipoPagamento tipoPagamentoEntrada) {
        log.info("[inicia] PagamentoApplicationService - savePagamentoByEntrada");
        pagamentoRepository.salvaPagamento(new Pagamento(matricula, tipoPagamentoEntrada));
        log.info("[finaliza] PagamentoApplicationService - savePagamentoByEntrada");
    }
    @Override
    public void deletePagamento(Long idPagamento) {
        log.info("[inicia] PagamentoApplicationService - deletePagamento");
        pagamentoRepository.deletePagamento(pagamentoRepository.getOnePagamento(idPagamento).getIdPagamento());
        log.info("[finaliza] PagamentoApplicationService - deletePagamento");
    }
}
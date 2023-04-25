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
    public PagamentoResponse newPagamento(UUID idMatricula, PagamentoRequest pagamentoRequest) {
        log.info("[inicia] PagamentoApplicationService - newPagamento");
        Matricula matricula = matriculaRepository.matriculaAtravesId(idMatricula);
        BigDecimal totalPago = pagamentoRepository.totalPago(matricula);
        BigDecimal saldoAPagar = matricula.getValorFinal().subtract(totalPago);
        if (pagamentoRequest.getValorPago().compareTo(saldoAPagar)<=0){
            Pagamento pagamento = pagamentoRepository.salva(new Pagamento(pagamentoRequest, matricula));
            log.info("[finaliza] PagamentoApplicationService - newPagamento");
            return new PagamentoResponse(pagamento);
        } else {
            throw APIException.build(HttpStatus.BAD_REQUEST,
                    "Pagamento maior que o serviço contratado." +
                            " Valor a Pagar: " + saldoAPagar);
        }
    }
    @Override
    public List<PagamentoResponse> getPagamentoByMatricula(UUID idMatricula) {
        log.info("[inicia] PagamentoApplicationService - getPagamentoByMatricula");
        Matricula matricula = matriculaRepository.matriculaAtravesId(idMatricula);
        List<Pagamento> pagamento = pagamentoRepository.getPagamento(matricula);
        log.info("[finaliza] PagamentoApplicationService - getPagamentoByMatricula");
        return PagamentoResponse.convert(pagamento);
    }
    @Override
    public PagamentoResponse getById(Long idPagamento) {
        log.info("[inicia] PagamentoApplicationService - getById");
        Pagamento pagamento = pagamentoRepository.getById(idPagamento);
        log.info("[finaliza] PagamentoApplicationService - getById");
        return new PagamentoResponse(pagamento);
    }
    @Override
    public Pagamento entrada(Matricula matricula, TipoPagamento tipoPagamentoEntrada) {
        log.info("[inicia] PagamentoApplicationService - entrada");
        Pagamento pagamento = pagamentoRepository.salva(new Pagamento(matricula, tipoPagamentoEntrada));
        log.info("[finaliza] PagamentoApplicationService - entrada");
        return pagamento;
    }
    @Override
    public void deleteById(Long idPagamento) {
        log.info("[inicia] PagamentoApplicationService - deleteById");
        pagamentoRepository.delete(pagamentoRepository.getById(idPagamento).getIdPagamento());
        log.info("[finaliza] PagamentoApplicationService - deleteById");
    }
}
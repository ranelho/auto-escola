package com.rlti.autoescola.orcamento.application.service;

import com.rlti.autoescola.cliente.application.service.ClienteService;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.orcamento.application.api.OrcamentoRequest;
import com.rlti.autoescola.orcamento.application.api.OrcamentoResponse;
import com.rlti.autoescola.orcamento.application.repository.OrcamentoRepository;
import com.rlti.autoescola.orcamento.domain.Orcamento;
import com.rlti.autoescola.servico.application.repository.ServicoRepository;
import com.rlti.autoescola.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import static com.rlti.autoescola.matricula.domain.Validacoes.validaOrcamento;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrcamentoApplicationService implements OrcamentoService {
    private final ClienteService clienteService;
    private final ServicoRepository servicoRepository;
    private final OrcamentoRepository orcamentoRepository;

    @Override
    public OrcamentoResponse criaNovoOrcamento(OrcamentoRequest orcamentoRequest) {
        log.info("[inicia] OrcamentoApplicationService - criaNovoOrcamento");
        Servico servico = servicoRepository.getById(orcamentoRequest.getIdServico());
        validaOrcamento(orcamentoRequest, servico);
        Cliente cliente = clienteService.verificaCliente(orcamentoRequest);
        Orcamento orcamento = orcamentoRepository.salvaOrcamento(new Orcamento(cliente,servico,orcamentoRequest));
        log.info("[finaliza] OrcamentoApplicationService - criaNovoOrcamento");
        return new OrcamentoResponse(orcamento);
    }

    @Override
    public OrcamentoResponse getOrcamentoById(Long idOrcamento) {
        log.info("[inicia] OrcamentoApplicationService - getOrcamentoById");
        Orcamento orcamento = orcamentoRepository.getOrcamentoById(idOrcamento);
        log.info("[finaliza] OrcamentoApplicationService - getOrcamentoById");
        return new OrcamentoResponse(orcamento);
    }
}
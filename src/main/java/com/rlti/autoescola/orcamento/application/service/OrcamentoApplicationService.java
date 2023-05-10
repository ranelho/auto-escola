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

import static com.rlti.autoescola.matricula.annotation.constraints.ValidaMatricula.validaSolicitacao;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrcamentoApplicationService implements OrcamentoService {
    private final OrcamentoRepository orcamentoRepository;
    private final ClienteService clienteService;
    private final ServicoRepository servicoRepository;

    @Override
    public OrcamentoResponse saveOrcamento(OrcamentoRequest orcamentoRequest) {
        log.info("[inicia] OrcamentoApplicationService - saveOrcamento");
        Servico servico = servicoRepository.getOneServico(orcamentoRequest.getIdServico());
        validaSolicitacao(orcamentoRequest, servico);
        Cliente cliente = clienteService.getOrcamentoByCliente(orcamentoRequest);
        Orcamento orcamento = orcamentoRepository.saveOrcamento(new Orcamento(cliente,servico,orcamentoRequest));
        log.info("[finaliza] OrcamentoApplicationService - saveOrcamento");
        return new OrcamentoResponse(orcamento);
    }

    @Override
    public OrcamentoResponse getOneOrcamento(Long idOrcamento) {
        log.info("[inicia] OrcamentoApplicationService - getOneOrcamento");
        Orcamento orcamento = orcamentoRepository.getOneOrcamento(idOrcamento);
        log.info("[finaliza] OrcamentoApplicationService - getOneOrcamento");
        return new OrcamentoResponse(orcamento);
    }
}
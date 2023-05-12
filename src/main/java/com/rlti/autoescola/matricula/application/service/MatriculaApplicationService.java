package com.rlti.autoescola.matricula.application.service;

import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.matricula.annotation.constraints.ValidaMatricula;
import com.rlti.autoescola.matricula.application.api.request.MatriculaAlteracaoRequest;
import com.rlti.autoescola.matricula.application.api.request.MatriculaRequest;
import com.rlti.autoescola.matricula.application.api.response.MatriculaDetalhadoResponse;
import com.rlti.autoescola.matricula.application.api.response.MatriculaIdResponse;
import com.rlti.autoescola.matricula.application.api.response.MatriculaListResponse;
import com.rlti.autoescola.matricula.application.repository.MatriculaRepository;
import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.orcamento.application.repository.OrcamentoRepository;
import com.rlti.autoescola.orcamento.domain.Orcamento;
import com.rlti.autoescola.pagamento.appiclation.service.PagamentoService;
import com.rlti.autoescola.pagamento.domain.Pagamento;
import com.rlti.autoescola.servico.application.repository.ServicoRepository;
import com.rlti.autoescola.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class MatriculaApplicationService implements MatriculaService{
    private final MatriculaRepository matriculaRepository;
    private final ClienteRepository clienteRepository;
    private final ServicoRepository servicoRepository;
    private final PagamentoService pagamentoService;
    private final OrcamentoRepository orcamentoRepository;
    private final ValidaMatricula validaMatricula;

    @Override
    public MatriculaIdResponse saveMatricula(MatriculaRequest matriculaRequest) {
        log.info("[inicia] MatriculaApplicationService - saveMatricula");
        Servico servico = servicoRepository.getOneServico(matriculaRequest.getIdServico());
        validaMatricula.validaSolicitacao(matriculaRequest, servico);
        Cliente cliente = clienteRepository.findOneCliente(matriculaRequest.getIdCliente());
        Matricula matricula = matriculaRepository.saveMatricula(new Matricula(cliente, servico,matriculaRequest));
        if (matriculaRequest.getValorEntrada().compareTo(BigDecimal.ZERO)>0){
            Pagamento pagamento = pagamentoService.savePagamentoByEntrada(matricula, TipoPagamento.valueOf(matriculaRequest.getTipoPagamentoEntrada()));
        }
        log.info("[finaliza] MatriculaApplicationService - saveMatricula");
        return MatriculaIdResponse.builder().idMatricula(matricula.getIdMatricula()).build();
    }

    @Override
    public MatriculaIdResponse saveMatriculaByOrcamento(String cpf) {
        log.info("[inicia] MatriculaApplicationService - saveMatriculaByOrcamento");
        Orcamento orcamento = orcamentoRepository.getOneOrcamentoByCpf(cpf);
        Matricula matricula = matriculaRepository.saveMatricula(new Matricula(orcamento));
        orcamentoRepository.deleteOrcamento(orcamento.getIdOrcamento());
        log.info("[finaliza] MatriculaApplicationService - saveMatriculaByOrcamento");
        return MatriculaIdResponse.builder().idMatricula(matricula.getIdMatricula()).build();
    }

    @Override
    public List<MatriculaListResponse> getAllMatriculas() {
        log.info("[inicia] MatriculaApplicationService - getAllMatriculas");
        List<Matricula> matriculas = matriculaRepository.getAllMatriculas();
        log.info("[finaliza] MatriculaApplicationService - getAllMatriculas");
        return MatriculaListResponse.converte(matriculas);
    }

    @Override
    public MatriculaDetalhadoResponse getOneMatricula(UUID idMatricula) {
        log.info("[inicia] MatriculaApplicationService - getOneMatricula");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        log.info("[finaliza] MatriculaApplicationService - getOneMatricula");
        return new MatriculaDetalhadoResponse(matricula);
    }

    @Override
    public void deleteMatricula(UUID idMatricula) {
        log.info("[inicia] MatriculaApplicationService - deleteMatricula");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        matriculaRepository.deleteMatricula(matricula);
        log.info("[finaliza] MatriculaApplicationService - deleteMatricula");
    }

    @Override
    public void updateMatricula(UUID idMatricula, MatriculaAlteracaoRequest request) {
        log.info("[inicia] MatriculaApplicationService - updateMatricula");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        validaMatricula.validaAlteracaoMatricula(matricula, request);
        matricula.altera(request);
        matriculaRepository.saveMatricula(matricula);
        log.info("[finaliza] MatriculaApplicationService - updateMatricula");
    }

    @Override
    public void finalizaMatricula(UUID idMatricula) {
        log.info("[inicia] MatriculaApplicationService - finalizaMatricula");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        matricula.finalizaMatricula();
        matriculaRepository.saveMatricula(matricula);
        log.info("[finaliza] MatriculaApplicationService - finalizaMatricula");
    }

    @Override
    public void ativaMatricula(UUID idMatricula) {
        log.info("[inicia] MatriculaApplicationService - ativaMatricula");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        matricula.ativaMatricula();
        matriculaRepository.saveMatricula(matricula);
        log.info("[finaliza] MatriculaApplicationService - ativaMatricula");
    }

    @Override
    public void cancelaMatricula(UUID idMatricula) {
        log.info("[inicia] MatriculaApplicationService - cancelaMatricula");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        matricula.cancelaMatricula();
        matriculaRepository.saveMatricula(matricula);
        log.info("[finaliza] MatriculaApplicationService - cancelaMatricula");
    }
}
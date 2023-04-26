package com.rlti.autoescola.matricula.application.service;

import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.cliente.domain.Cliente;
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

import static com.rlti.autoescola.matricula.annotation.constraints.Valid.validaAlteracaoMatricula;
import static com.rlti.autoescola.matricula.annotation.constraints.Valid.validaSolicitacao;

@Service
@Log4j2
@RequiredArgsConstructor
public class MatriculaApplicationService implements MatriculaService{
    private final ClienteRepository clienteRepository;
    private final MatriculaRepository matriculaRepository;
    private final ServicoRepository servicoRepository;
    private final OrcamentoRepository orcamentoRepository;
    private final PagamentoService pagamentoService;

    @Override
    public MatriculaIdResponse saveMatricula(MatriculaRequest matriculaRequest) {
        log.info("[inicia] MatriculaApplicationService - criaNovaMatricula");
        Servico servico = servicoRepository.getOneServico(matriculaRequest.getIdServico());
        validaSolicitacao(matriculaRequest, servico);
        Cliente cliente = clienteRepository.findOneCliente(matriculaRequest.getIdCliente());
        Matricula matricula = matriculaRepository.salva(new Matricula(cliente, servico,matriculaRequest));
        if (matriculaRequest.getValorEntrada().compareTo(BigDecimal.ZERO)>0){
            Pagamento pagamento = pagamentoService.entrada(matricula, TipoPagamento.valueOf(matriculaRequest.getTipoPagamentoEntrada()));
        }
        log.info("[finaliza] MatriculaApplicationService - criaNovaMatricula");
        return MatriculaIdResponse.builder().idMatricula(matricula.getIdMatricula()).build();
    }

    @Override
    public MatriculaIdResponse saveMatriculaByOrcamento(String cpf) {
        log.info("[inicia] MatriculaApplicationService - criaNovaMatricula-Orcamento");
        Orcamento orcamento = orcamentoRepository.findByCpf(cpf);
        Matricula matricula = matriculaRepository.salva(new Matricula(orcamento));
        orcamentoRepository.deleteOrcamento(orcamento.getIdOrcamento());
        log.info("[finaliza] MatriculaApplicationService - criaNovaMatricula-Orcamento");
        return MatriculaIdResponse.builder().idMatricula(matricula.getIdMatricula()).build();
    }

    @Override
    public List<MatriculaListResponse> getAllMatriculas() {
        log.info("[inicia] MatriculaApplicationService - buscaTodasMatriculas");
        List<Matricula> matriculas = matriculaRepository.getAllMatriculas();
        log.info("[finaliza] MatriculaApplicationService - buscaTodasMatriculas");
        return MatriculaListResponse.converte(matriculas);
    }

    @Override
    public MatriculaDetalhadoResponse getOneMatricula(UUID idMatricula) {
        log.info("[inicia] MatriculaApplicationService - matriculaAtravesId");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        log.info("[finaliza] MatriculaApplicationService - matriculaAtravesId");
        return new MatriculaDetalhadoResponse(matricula);
    }

    @Override
    public void deleteMatricula(UUID idMatricula) {
        log.info("[inicia] MatriculaApplicationService - delete");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        matriculaRepository.deleteMatricula(matricula);
        log.info("[finaliza] MatriculaApplicationService - delete");
    }

    @Override
    public void updateMatricula(UUID idMatricula, MatriculaAlteracaoRequest request) {
        log.info("[inicia] MatriculaApplicationService - update");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        validaAlteracaoMatricula(matricula, request);
        matricula.altera(request);
        matriculaRepository.salva(matricula);
        log.info("[finaliza] MatriculaApplicationService - update");
    }

    @Override
    public void finalizaMatricula(UUID idMatricula) {
        log.info("[inicia] MatriculaApplicationService - finalizaMatricula");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        matricula.finalizaMatricula();
        matriculaRepository.salva(matricula);
        log.info("[finaliza] MatriculaApplicationService - finalizaMatricula");
    }

    @Override
    public void ativaMatricula(UUID idMatricula) {
        log.info("[inicia] MatriculaApplicationService - ativaMatricula");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        matricula.ativaMatricula();
        matriculaRepository.salva(matricula);
        log.info("[finaliza] MatriculaApplicationService - ativaMatricula");
    }

    @Override
    public void cancelaMatricula(UUID idMatricula) {
        log.info("[inicia] MatriculaApplicationService - cancelaMatricula");
        Matricula matricula = matriculaRepository.getOneMatricula(idMatricula);
        matricula.cancelaMatricula();
        matriculaRepository.salva(matricula);
        log.info("[finaliza] MatriculaApplicationService - cancelaMatricula");
    }
}
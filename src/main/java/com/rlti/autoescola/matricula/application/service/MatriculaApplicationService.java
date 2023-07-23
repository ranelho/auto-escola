package com.rlti.autoescola.matricula.application.service;

import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.matricula.annotation.constraints.ValidaMatricula;
import com.rlti.autoescola.matricula.application.api.request.MatriculaRequest;
import com.rlti.autoescola.matricula.application.api.request.MatriculaUpdateRequest;
import com.rlti.autoescola.matricula.application.api.response.MatriculaDetalhadoResponse;
import com.rlti.autoescola.matricula.application.api.response.MatriculaIdResponse;
import com.rlti.autoescola.matricula.application.api.response.MatriculaListResponse;
import com.rlti.autoescola.matricula.application.repository.MatriculaRepository;
import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.orcamento.application.repository.OrcamentoRepository;
import com.rlti.autoescola.pagamento.appiclation.service.PagamentoService;
import com.rlti.autoescola.servico.application.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static com.rlti.autoescola.matricula.application.api.response.MatriculaIdResponse.*;
import static com.rlti.autoescola.matricula.domain.TipoPagamento.valueOf;

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
    public MatriculaIdResponse saveMatricula(MatriculaRequest request) {
        log.info("[inicia] MatriculaApplicationService - saveMatricula");
        var servico = servicoRepository.getOneServico(request.getIdServico());
        validaMatricula.validaSolicitacao(request, servico);
        var cliente = clienteRepository.findOneCliente(request.getIdCliente());
        var matricula = matriculaRepository.saveMatricula(new Matricula(cliente, servico,request));
        if (request.getValorEntrada().compareTo(BigDecimal.ZERO)>0){
            pagamentoService.savePagamentoByEntrada(matricula, valueOf(request.getTipoPagamentoEntrada()));
        }
        log.info("[finaliza] MatriculaApplicationService - saveMatricula");
        return builder().idMatricula(matricula.getIdMatricula()).build();
    }

    @Override
    public MatriculaIdResponse saveMatriculaByOrcamento(String cpf) {
        log.info("[inicia] MatriculaApplicationService - saveMatriculaByOrcamento");
        var orcamento = orcamentoRepository.getOneOrcamentoByCpf(cpf);
        var matricula = matriculaRepository.saveMatricula(new Matricula(orcamento));
        orcamentoRepository.deleteOrcamento(orcamento.getIdOrcamento());
        log.info("[finaliza] MatriculaApplicationService - saveMatriculaByOrcamento");
        return builder().idMatricula(matricula.getIdMatricula()).build();
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
        var matricula = matriculaRepository.getOneMatricula(idMatricula);
        log.info("[finaliza] MatriculaApplicationService - getOneMatricula");
        return new MatriculaDetalhadoResponse(matricula);
    }

    @Override
    public void deleteMatricula(UUID idMatricula) {
        log.info("[inicia] MatriculaApplicationService - deleteMatricula");
        var matricula = matriculaRepository.getOneMatricula(idMatricula);
        matriculaRepository.deleteMatricula(matricula);
        log.info("[finaliza] MatriculaApplicationService - deleteMatricula");
    }

    @Override
    public void updateMatricula(UUID idMatricula, MatriculaUpdateRequest request) {
        log.info("[inicia] MatriculaApplicationService - updateMatricula");
        var matricula = matriculaRepository.getOneMatricula(idMatricula);
        validaMatricula.validaAlteracaoMatricula(matricula, request);
        matricula.altera(request);
        matriculaRepository.saveMatricula(matricula);
        log.info("[finaliza] MatriculaApplicationService - updateMatricula");
    }

    @Override
    public void finalizaMatricula(UUID idMatricula) {
        log.info("[inicia] MatriculaApplicationService - finalizaMatricula");
        var matricula = matriculaRepository.getOneMatricula(idMatricula);
        matricula.finalizaMatricula();
        matriculaRepository.saveMatricula(matricula);
        log.info("[finaliza] MatriculaApplicationService - finalizaMatricula");
    }

    @Override
    public void ativaMatricula(UUID idMatricula) {
        log.info("[inicia] MatriculaApplicationService - ativaMatricula");
        var matricula = matriculaRepository.getOneMatricula(idMatricula);
        matricula.ativaMatricula();
        matriculaRepository.saveMatricula(matricula);
        log.info("[finaliza] MatriculaApplicationService - ativaMatricula");
    }

    @Override
    public void cancelaMatricula(UUID idMatricula) {
        log.info("[inicia] MatriculaApplicationService - cancelaMatricula");
        var matricula = matriculaRepository.getOneMatricula(idMatricula);
        matricula.cancelaMatricula();
        matriculaRepository.saveMatricula(matricula);
        log.info("[finaliza] MatriculaApplicationService - cancelaMatricula");
    }
}
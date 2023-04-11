package com.rlti.autoescola.matricula.application.service;

import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.matricula.application.api.MatriculaDetalhadoResponse;
import com.rlti.autoescola.matricula.application.api.MatriculaListResponse;
import com.rlti.autoescola.matricula.application.api.MatriculaRequest;
import com.rlti.autoescola.matricula.application.api.MatriculaResponse;
import com.rlti.autoescola.matricula.application.repository.MatriculaRepository;
import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.servico.application.repository.ServicoRepository;
import com.rlti.autoescola.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class MatriculaApplicationService implements MatriculaService{
    private final ClienteRepository clienteRepository;
    private final MatriculaRepository matriculaRepository;
    private final ServicoRepository servicoRepository;

    @Override
    public MatriculaResponse criaNovaMatricula(MatriculaRequest matriculaRequest) {
        log.info("[inicia] MatriculaApplicationService - criaNovaMatricula");
        Cliente cliente = clienteRepository.buscaClientePorId(matriculaRequest.getIdCliente());
        Servico servico = servicoRepository.getById(matriculaRequest.getIdServico());
        Matricula matricula = matriculaRepository.salva(new Matricula(cliente, servico, matriculaRequest));
        log.info("[finaliza] MatriculaApplicationService - criaNovaMatricula");
        return MatriculaResponse
                .builder()
                .idMatricula(matricula.getIdMatricula())
                .build();
    }

    @Override
    public List<MatriculaListResponse> buscaTodasMatriculas() {
        log.info("[inicia] MatriculaApplicationService - buscaTodasMatriculas");
        List<Matricula> matriculas = matriculaRepository.buscaTodasMatriculas();
        log.info("[finaliza] MatriculaApplicationService - buscaTodasMatriculas");
        return MatriculaListResponse.converte(matriculas);
    }

    @Override
    public MatriculaDetalhadoResponse matriculaAtravesId(UUID idMatricula) {
        log.info("[inicia] MatriculaApplicationService - matriculaAtravesId");
        Matricula matricula = matriculaRepository.matriculaAtravesId(idMatricula);
        log.info("[finaliza] ClienteApplicationService - matriculaAtravesId");
        return new MatriculaDetalhadoResponse(matricula);
    }
}

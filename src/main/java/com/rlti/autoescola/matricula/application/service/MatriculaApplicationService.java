package com.rlti.autoescola.matricula.application.service;

import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.matricula.application.api.MatriculaRequest;
import com.rlti.autoescola.matricula.application.api.MatriculaResponse;
import com.rlti.autoescola.matricula.application.repository.MatriculaInfraRepository;
import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MatriculaApplicationService implements MatriculaService{
    private final ClienteRepository clienteRepository;
    private final ServicoRepository servicoRepository;
    private final MatriculaInfraRepository matriculaInfraRepository;

    @Override
    public MatriculaResponse criaNovaMatricula(MatriculaRequest matriculaRequest) {
        log.info("[finaliza] MatriculaApplicationService - criaNovaMatricula");
        Cliente cliente = clienteRepository.buscaClientePorId(matriculaRequest.getIdCliente());
        Servico servico = servicoRepository.getById(matriculaRequest.getIdServico());
        //ValidaCategoria.isCombinationValid(matriculaRequest.getTipoServico(),servico.getCategoria());
        Matricula matricula = matriculaRepository.salvaMatricula(new Matricula(cliente,servico, matriculaRequest));
        log.info("[finaliza] MatriculaApplicationService - criaNovaMatricula");
        return new MatriculaResponse(matricula);
    }
}

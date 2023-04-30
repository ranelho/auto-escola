package com.rlti.autoescola.relatorios.application.service;

import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.frota.veiculo.application.repository.VeiculoRepository;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import com.rlti.autoescola.instrutor.application.repository.InstrutorRepository;
import com.rlti.autoescola.instrutor.domain.Instrutor;
import com.rlti.autoescola.matricula.application.repository.MatriculaRepository;
import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.relatorios.application.api.respose.RelatorioClientesResponse;
import com.rlti.autoescola.relatorios.application.api.respose.RelatorioInstrutorResponse;
import com.rlti.autoescola.relatorios.application.api.respose.RelatorioMatriculasAtivasResponse;
import com.rlti.autoescola.relatorios.application.api.respose.RelatorioVeiculosResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class RelatoriosApplicationService implements RelatoriosService {
    private final ClienteRepository clienteRepository;
    private final MatriculaRepository matriculaRepository;
    private final VeiculoRepository veiculoRepository;
    private final InstrutorRepository instrutorRepository;

    @Override
    public List<RelatorioClientesResponse> getAllClientes() {
        log.info("[inicia] RelatoriosApplicationService - getAllClientes");
        List<Cliente> clientes = clienteRepository.getAllClientes();
        log.info("[Finaliza] RelatoriosApplicationService - getAllClientes");
        return RelatorioClientesResponse.convert(clientes);
    }

    @Override
    public List<RelatorioMatriculasAtivasResponse> getAllMatriculasAtivas() {
        log.info("[inicia] RelatoriosApplicationService - getAllMatriculasAtivas");
        List<Matricula> matriculas = matriculaRepository.getAllMatriculasAtivas();
        log.info("[Finaliza] RelatoriosApplicationService - getAllMatriculasAtivas");
        return RelatorioMatriculasAtivasResponse.convert(matriculas);
    }

    @Override
    public List<RelatorioVeiculosResponse> getAllVeiculos() {
        log.info("[inicia] RelatoriosApplicationService - getAllVeiculos");
        List<Veiculo> veiculos = veiculoRepository.getAllVeiculo();
        log.info("[Finaliza] RelatoriosApplicationService - getAllVeiculos");
        return RelatorioVeiculosResponse.converte(veiculos);
    }

    @Override
    public List<RelatorioInstrutorResponse> getAllInstrutor() {
        log.info("[inicia] RelatoriosApplicationService - getAllInstrutor");
        List<Instrutor > instrutors = instrutorRepository.getAllInstrutors();
        log.info("[Finaliza] RelatoriosApplicationService - getAllInstrutor");
        return RelatorioInstrutorResponse.converte(instrutors);
    }
}

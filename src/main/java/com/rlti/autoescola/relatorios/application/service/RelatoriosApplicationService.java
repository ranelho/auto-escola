package com.rlti.autoescola.relatorios.application.service;

import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.relatorios.application.api.RelatorioClientesResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class RelatoriosApplicationService implements RelatoriosService {
    private final ClienteRepository clienteRepository;

    @Override
    public List<RelatorioClientesResponse> getAllClientes() {
        log.info("[inicia] RelatoriosApplicationService - getAllClientes");
        List<Cliente> clientes = clienteRepository.getAllClientes();
        log.info("[Finaliza] RelatoriosApplicationService - getAllClientes");
        return RelatorioClientesResponse.convert(clientes);
    }
}

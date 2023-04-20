package com.rlti.autoescola.cliente.application.service;

import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.cliente.application.repository.FotoRepository;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.cliente.domain.Foto;
import com.rlti.autoescola.handler.TamanhoArquivoExcedidoException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class FotoApplicationService implements FotoService {
    private final FotoRepository fotoRepository;
    private final ClienteRepository clienteRepository;
    private static final long TAMANHO_MAXIMO = 1 * 1024 * 1024; // 1MB

    @Override
    public void salvarFoto(UUID idCliente, MultipartFile file) throws IOException {
        log.info("[inicia] FotoApplicationService - salvarFoto");
        if (file.getSize() > TAMANHO_MAXIMO) {
            throw new TamanhoArquivoExcedidoException("O tamanho máximo permitido é 1 MB.");
        }else {
            Cliente cliente = clienteRepository.buscaClientePorId(idCliente);
            fotoRepository.salva(new Foto(cliente, file));
        }
        log.info("[fim] FotoApplicationService - salvarFoto");
    }
}

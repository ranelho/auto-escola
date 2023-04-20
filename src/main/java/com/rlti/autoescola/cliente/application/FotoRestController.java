package com.rlti.autoescola.cliente.application;

import com.rlti.autoescola.cliente.application.service.FotoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class FotoRestController implements FotoApi {
    private final FotoService fotoService;

    @Override
    public void salvarFoto(UUID idCliente, MultipartFile file) throws IOException {
        log.info("[inicia] FotoRestController - salvarFoto");
        fotoService.salvarFoto(idCliente, file);
        log.info("[fim] FotoRestController - salvarFoto");
    }

    @Override
    public FotoResponse buscarFoto(UUID idCliente) throws IOException {
        log.info("[inicia] FotoRestController - buscarFoto");
        FotoResponse fotoResponse = fotoService.buscarFoto(idCliente);
        log.info("[fim] FotoRestController - buscarFoto");
        return fotoResponse;
    }
}

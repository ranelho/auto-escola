package com.rlti.autoescola.cliente.application.service;

import com.rlti.autoescola.cliente.application.FotoResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public interface FotoService {
    void salvarFoto(UUID idCliente, MultipartFile file) throws IOException;
    FotoResponse buscarFoto(UUID idCliente);
}

package com.rlti.autoescola.cliente.application.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public interface ImagemService {
    void saveImagem(UUID idCliente, MultipartFile imagem) throws IOException;
}

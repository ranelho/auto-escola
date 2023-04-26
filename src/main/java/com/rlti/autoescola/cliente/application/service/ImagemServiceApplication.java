package com.rlti.autoescola.cliente.application.service;

import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.cliente.application.repository.ImagemRepository;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.cliente.domain.Imagem;
import com.rlti.autoescola.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ImagemServiceApplication implements ImagemService {
    private final ImagemRepository imagemRepository;
    private final ClienteRepository clienteRepository;

    @Override
    public void saveImagem(UUID idCliente, MultipartFile imagem) throws IOException {
        log.info("[inicia] ImagemServiceApplication - editaImagem");
        Cliente cliente = clienteRepository.findOneCliente(idCliente);
        Optional<Imagem> optionalImagem = imagemRepository.findByCliente(cliente);
        if (optionalImagem.isPresent()){
            atualizarImagemCliente(cliente, imagem);
        }else {
            Imagem novaImagem = imagemRepository.salva(new Imagem(cliente, imagem));
        }
        log.info("[finaliza] ImagemServiceApplication - editaImagem");
    }

    private void atualizarImagemCliente(Cliente cliente, MultipartFile imagem) throws IOException {
        log.info("[inicia] ImagemServiceApplication - atualizarImagemCliente");
        Imagem imagemAtual = imagemRepository.findByCliente(cliente)
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,"Imagem não encontrado!"));
        imagemAtual.altera(imagem.getBytes());
        imagemRepository.salva(imagemAtual);
        log.info("[finaliza] ImagemServiceApplication - atualizarImagemCliente");
    }
}

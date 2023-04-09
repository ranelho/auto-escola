package com.rlti.autoescola.instrutor.application.api;

import com.rlti.autoescola.instrutor.application.service.InstrutorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class InstrutorRestController implements InstrutorApi {
    private final InstrutorService instrutorService;

    @Override
    public InstrutorIdResponse post(InstrutorResquest resquest) {
        log.info("[inicia] InstrutorRestController -  post");
        InstrutorIdResponse idResponse = instrutorService.post(resquest);
        log.info("[finaliza] InstrutorRestController -  post");
        return idResponse;
    }

    @Override
    public InstrutorResponse getInstrutor(UUID idInstrutor) {
        log.info("[inicia] InstrutorRestController -  getInstrutor");
        InstrutorResponse response = instrutorService.getInstrutor(idInstrutor);
        log.info("[finaliza] InstrutorRestController -  getInstrutor");
        return response;
    }

    @Override
    public void update(UUID idInstrutor, InstrutorUpdateResquest updateRequest) {
        log.info("[inicia] InstrutorRestController -  getInstrutor");
        instrutorService.update(idInstrutor, updateRequest);
        log.info("[finaliza] InstrutorRestController -  getInstrutor");
    }
}

package com.rlti.autoescola.instrutor.application.service;

import com.rlti.autoescola.instrutor.application.api.InstrutorIdResponse;
import com.rlti.autoescola.instrutor.application.api.InstrutorResponse;
import com.rlti.autoescola.instrutor.application.api.InstrutorResquest;

import java.util.UUID;

public interface InstrutorService {
    InstrutorIdResponse post(InstrutorResquest resquest);
    InstrutorResponse getInstrutor(UUID idInstrutor);
}

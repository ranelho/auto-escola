package com.rlti.autoescola.instrutor.application.service;

import com.rlti.autoescola.instrutor.application.api.InstrutorIdResponse;
import com.rlti.autoescola.instrutor.application.api.InstrutorResponse;
import com.rlti.autoescola.instrutor.application.api.InstrutorResquest;
import com.rlti.autoescola.instrutor.application.api.InstrutorUpdateResquest;

import java.util.List;
import java.util.UUID;

public interface InstrutorService {
    InstrutorIdResponse post(InstrutorResquest resquest);
    InstrutorResponse getInstrutor(UUID idInstrutor);
    void update(UUID idInstrutor, InstrutorUpdateResquest updateRequest);
    List<InstrutorResponse> getAllInstrutors();
}

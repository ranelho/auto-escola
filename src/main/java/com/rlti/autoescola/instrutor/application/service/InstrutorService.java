package com.rlti.autoescola.instrutor.application.service;

import com.rlti.autoescola.instrutor.application.api.InstrutorIdResponse;
import com.rlti.autoescola.instrutor.application.api.InstrutorResquest;

public interface InstrutorService {
    InstrutorIdResponse post(InstrutorResquest resquest);
}

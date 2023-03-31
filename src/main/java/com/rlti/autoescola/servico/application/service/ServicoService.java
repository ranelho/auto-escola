package com.rlti.autoescola.servico.application.service;

import com.rlti.autoescola.servico.application.api.ServicoIdResponse;
import com.rlti.autoescola.servico.application.api.ServicoRequest;

public interface ServicoService {
    ServicoIdResponse saveFrota(ServicoRequest request);
}

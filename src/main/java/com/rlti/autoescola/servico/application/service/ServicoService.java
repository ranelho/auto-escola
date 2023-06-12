package com.rlti.autoescola.servico.application.service;

import com.rlti.autoescola.servico.application.api.ServicoIdResponse;
import com.rlti.autoescola.servico.application.api.ServicoUpdateRequest;
import com.rlti.autoescola.servico.application.api.SevicoRecord;
import com.rlti.autoescola.servico.domain.Servico;

import java.util.List;
import java.util.UUID;

public interface ServicoService {
    ServicoIdResponse saveServico(SevicoRecord record);
    Servico getOneServico(UUID idServico);
    List<Servico> getAllServicos();
    void deleteServico(UUID idServico);
    void updateServico(UUID idServico, ServicoUpdateRequest updateRequest);
    void updateServicoStatus(UUID idServico);
}